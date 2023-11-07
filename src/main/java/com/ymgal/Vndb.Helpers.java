package com.ymgal;

public class Vndb
	{


		#region .  Stream Read/Write  .



		#endregion

		#region .  Request Formatting  .

		/// <summary>
		///		Formats a request with the Terminating Character
		/// </summary>
		/// <param name="data">The data to append the Terminating Character to</param>
		/// <returns>A string that ends with 0x04</returns>
		protected Byte[] FormatRequest(String data)
			=> this.GetBytes($"{data}{Constants.EotChar}");

		/// <summary>
		///		Converts an object to json and formats the request with the Terminating Character
		/// </summary>
		/// <param name="prefix">What to put before the <paramref name="data"/></param>
		/// <param name="data">The object to be Json Encoded for transmission</param>
		/// <param name="includeNull">Indicates if null values should be allowed</param>
		/// <returns>A formatted string that ends with 0x04</returns>
		protected Byte[] FormatRequest<T>(String prefix, T data, Boolean includeNull = true)
		{
			if (data == null && !includeNull)
				return this.FormatRequest(prefix);

			var json = JsonConvert.SerializeObject(data,
				new JsonSerializerSettings
				{
					ContractResolver = VndbContractResolver.Instance,
					NullValueHandling = includeNull
						? NullValueHandling.Include
						: NullValueHandling.Ignore,
				});

			return this.FormatRequest(json == "null" ? prefix : $"{prefix} {json}");
		}

		/// <inheritdoc cref="Encoding.GetBytes(String)"/>
		protected Byte[] GetBytes(String data)
			=> Encoding.UTF8.GetBytes(data);

		/// <inheritdoc cref="Encoding.GetString(Byte[])"/>
		protected String GetString(Byte[] data)
			=> Encoding.UTF8.GetString(data);

		#endregion

		#region .  IDisposable  .

		/// <summary>
		///		Disposes of the current instance
		/// </summary>
		public void Dispose()
			=> ((IDisposable) this).Dispose();

		/// <summary>
		///		Disposes of the current instance
		/// </summary>
		void IDisposable.Dispose()
		{
			this.Dispose(true);
			GC.SuppressFinalize(this);
		}

		/// <summary>
		///		Disposes of all IDisposable properties
		/// </summary>
		protected void Dispose(Boolean disposing)
		{
			if (!disposing)
				return;

#if netstandard1_3
			this.Client?.Dispose();
#endif
			this.Client = null;

			this.Stream?.Dispose();
			this.Stream = null;

			this.CancellationTokenSource?.Dispose();
			this.CancellationTokenSource = null;
		}

		#endregion

		/// <summary>
		///		Completely logout, disposing of any stored passwords as well of the connection
		/// </summary>
		public void Logout()
		{
#if UserAuth
			this.Password?.Dispose();
#endif
			this.Dispose();
		}

		/// <summary>
		///		Attempts to login to the Vndb API, including making the initial connection, optionally connecting via a SslStream and sending the Login Request itself
		/// </summary>
		/// <returns>True if already logged in, or successfully logged in. Otherwise false.</returns>
		protected async Task<Boolean> LoginAsync()
		{
			if (this.Client?.Connected == true && this.LoggedIn)
				return true;

			// Optionally dispose the old client, and create a new one
			this.InitializeClient();

			await this.Client.ConnectAsync(Constants.ApiDomain, this.UseTls ? Constants.ApiPortTls : Constants.ApiPort)
				.ConfigureAwait(false);

			if (this.UseTls)
			{
				// If UseTls was set to true, we want to use a SslStream to do our security magic
				var stream = new SslStream(this.Client.GetStream());
				await stream.AuthenticateAsClientAsync(Constants.ApiDomain).ConfigureAwait(false);
				this.Stream = stream;
			}
			else
			{
				// Otherwise, just use the NetworkStream directly.
				this.Stream = this.Client.GetStream();
			}

			this.RenewCts();



			var login = new Login();

			await this.SendDataAsync(this.FormatRequest(Constants.LoginCommand, login, false), this.CancellationTokenSource.Token)
				.TimeoutAfter(this.SendTimeout)
				.ConfigureAwait(false);

			this.RenewCts();
			var response = await this.GetResponseAsync(this.CancellationTokenSource.Token)
				.TimeoutAfter(this.ReceiveTimeout)
				.ConfigureAwait(false);

			// Success!
			if (response == Constants.Ok)
			{
				this.LoggedIn = true;
				return true;
			}

			// No response returned...?
			if (response.IsEmpty()) // We do not want to provide the full request/command here. It contains the password :o
				throw new UnexpectedResponseException("login", response);

			var results = response.ToVndbResults();
			// If we don't get Error, then we actually don't know what this response is.
			if (results.Length != 2 || results[0] != Constants.Error) // We do not want to provide the full request/command here. It contains the password :o
				throw new UnexpectedResponseException("login", response);

			this.ParseError(results[1]);
			return false;
		}

		/// <summary>
		///		Disposes the old state of the Vndb class, and re-creates the internal <see cref="TcpClient"/>
		/// </summary>
		protected void InitializeClient()
		{
			this.Dispose(true);

			this.Client = new TcpClient
			{
				SendBufferSize = this.SendBufferSize,
				ReceiveBufferSize = this.ReceiveBufferSize,
			};

			this.LoggedIn = false;
		}

		/// <summary>
		///		Disposes of the old CancellationTokenSource if it exists, and assigns a new one to <see cref="CancellationTokenSource"/>
		/// </summary>
		protected void RenewCts()
		{
			this.CancellationTokenSource?.Dispose();
			this.CancellationTokenSource = new CancellationTokenSource();
		}
	}

