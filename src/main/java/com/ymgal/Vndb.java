package com.ymgal;

import com.ymgal.Interfaces.IVndbError;
import com.ymgal.model.VersionStatus;

import java.net.Socket;

/// <summary>
///		The main class to issue get and set commands to the Vndb API with
/// </summary>
public class Vndb {
	//Version in Year.Month.Day
	private static final String ApiVer = "2020-11-13";
	private static VersionStatus ApiStatus = VersionStatus.Incomplete;

	/// <inheritdoc cref="TcpClient.SendBufferSize"/>
	public Integer SendBufferSize = 4096;

	/// <inheritdoc cref="TcpClient.ReceiveBufferSize"/>
	public Integer ReceiveBufferSize = 4096;


	/// <summary>
	///		Sets whether <see cref="VndbFlags"/> should be checked before being sent
	/// </summary>
	public Boolean CheckFlags = true;


	/// <summary>
	///		Indicates if the instance has logged in yet or not
	/// </summary>
	protected Boolean LoggedIn;


	/// <summary>
	///		The last error that occured will be stored here until another command is sent
	/// </summary>
	protected IVndbError LastError;


	/// <summary>
	///		The Connections Client
	/// </summary>
	protected Socket Client;

	/// <summary>
	///		The raw json of the last error.
	/// </summary>
	protected String LastErrorJson;

	/// <summary>
	///		A helper method to set the Client Name and Client Version sent to the Vndb Api
	/// </summary>
	/// <param name="clientName">The name of your client</param>
	/// <param name="clientVersion">The version of your client. Valid values: a-z 0-9 _ . / -</param>
	/// <returns>The <see cref="Vndb"/> instance</returns>
	/// <exception cref="ArgumentOutOfRangeException">When <paramref name="clientVersion"/> is not a valid <see cref="Version"/></exception>
	public Vndb WithClientDetails(String clientName, String clientVersion) {
		VndbUtils.ClientName = clientName;
		VndbUtils.ClientVersion = clientVersion;
		return this;
	}

	// ---------Error Method------------

	/// <summary>
	///		Parses a Vndb Error json result to determine the error, and stores it at <see cref="Vndb.LastError"/>
	/// </summary>
	/// <param name="json">The Error json</param>
//	protected void ParseError(String json)
//	{
//		this.LastErrorJson = json;
//
//		var response = JsonHelper.parse(json);
//
//		if (!response.TryGetValue("id", StringComparison.OrdinalIgnoreCase, out var typeToken))
//			return;
//
//		switch (typeToken.Value<String>())
//		{
//			case "parse":
//				this.LastError = Error.Build<ParseError>(response);
//				break;
//			case "missing":
//				this.LastError = Error.Build<MissingError>(response);
//				break;
//			case "badarg":
//				this.LastError = Error.Build<BadArgumentError>(response);
//				break;
//			case "needlogin":
//				this.LastError = Error.Build<LoginRequiredError>(response);
//				break;
//			case "throttled":
//				this.LastError = Error.Build<ThrottledError>(response);
//				break;
//			case "auth":
//				this.LastError = Error.Build<BadAuthenticationError>(response);
//				break;
//			case "loggedin":
//				this.LastError = Error.Build<LoggedInError>(response);
//				break;
//			case "gettype":
//				this.LastError = Error.Build<GetTypeError>(response);
//				break;
//			case "getinfo":
//				this.LastError = Error.Build<GetInfoError>(response);
//				break;
//			case "filter":
//				this.LastError = Error.Build<InvalidFilterError>(response);
//				break;
//			case "settype":
//				this.LastError = Error.Build<SetTypeError>(response);
//				break;
//			default:
//				this.LastError = null;
//				break;
//		}
//	}

	/// <summary>
	///		Returns the Json of the last error to occur
	/// </summary>
	/// <returns>Returns the Json of the last error to occur</returns>
	public String GetLastErrorJson() {
		return this.LastErrorJson;
	}

	/// <summary>
	///		Returns a <see cref="IVndbError"/> of the last error to occur
	/// </summary>
	/// <returns>Returns a <see cref="IVndbError"/> of the last error to occur</returns>
	public IVndbError GetLastError() {
		return this.LastError;
	}


	//---------------------Stream Method-----------------

	/// <summary>
	///		<para>The most generic get request helper.</para>
	///		<para>It takes the request data, ensures the user is logged in (and logs them in if they are not), then sends the request and recieves the response</para>
	///		<para>Once the response is recieved, it checks to see if it is a known response, and returns an approiate Model or sets the Error and returns null</para>
	/// </summary>
	/// <typeparam name="T">The Model to return if the response is a result set</typeparam>
	/// <param name="requestData">The request to send to the Vndb Api</param>
	/// <returns><typeparamref name="T"/> or null</returns>
	protected async Task<T> SendGetRequestInternalAsync<T>(Byte[] requestData)
	where T : class
	{
		if (!await this.LoginAsync().ConfigureAwait(false))
		return null;

		Debug.WriteLine(this.GetString(requestData)); // Only performance issue in Debug build
		this.RenewCts();
		await this.SendDataAsync(requestData, this.CancellationTokenSource.Token)
			.TimeoutAfter(this.SendTimeout) // I wonder what happens if sending doesn't complete? :o
			.ConfigureAwait(false);

		this.RenewCts();
		var response = await this.GetResponseAsync(this.CancellationTokenSource.Token)
			.TimeoutAfter(this.ReceiveTimeout)
			.ConfigureAwait(false);
		Debug.WriteLine($"Get Response | {response}");

		var results = response.ToVndbResults();
		if (results.Length == 2 &&
				(results[0] == Constants.Results || results[0] == Constants.DbStats))
			return results[1].FromJson<T>();

		if (results.Length != 2 || results[0] != Constants.Error)
			throw new UnexpectedResponseException(this.GetString(requestData), response);

		this.ParseError(results[1]);
		return null;
	}

	/// <summary>
	///		<para>The generic set request helper</para>
	///		<para>It takes the data to send to the Vndb API, and encodes it then sends the data and recieves a response</para>
	///		<para>Once a response is received, it checks to see if it is a known response, and returns an approiate Model or sets the Error and returns null</para>
	/// </summary>
	/// <param name="method">The method to use</param>
	/// <param name="id">The Id of the Visual Novel</param>
	/// <param name="data">The data to be json encoded</param>
	/// <param name="includeNulls">Should null values be included in the request</param>
	/// <returns>True if the set method was a success, false otherwise</returns>
	protected async Task<Boolean> SendSetRequestInternalAsync(String method, UInt32 id, Object data, Boolean includeNulls = false)
	{
		// Ensure we're logged in and authenticated
#if UserAuth
		if (!await this.LoginAsync().ConfigureAwait(false) && this.IsUserAuthenticated)
#else
		if (!await this.LoginAsync().ConfigureAwait(false))
#endif
		return false;

		// For logging
		var requestData = this.FormatRequest($"{method} {id}", data, includeNulls);
		Debug.WriteLine($"Set Send | {this.GetString(requestData)}"); // Only performance issue in Debug build
		this.RenewCts(); // Send the data with a fresh CancellationToken
		await this.SendDataAsync(requestData, this.CancellationTokenSource.Token)
			.TimeoutAfter(this.SendTimeout)
			.ConfigureAwait(false);

		this.RenewCts(); // Receive the response with a fresh CancellationToken
		var response = await this.GetResponseAsync(this.CancellationTokenSource.Token)
			.TimeoutAfter(this.ReceiveTimeout)
			.ConfigureAwait(false);
		Debug.WriteLine($"Set Response | {response}");

		// Parse the response, expecting 1 value equal to "ok"
		var results = response.ToVndbResults();
		if (results[0] == Constants.Ok)
			return true;

		if (results.Length == 2 && results[0] != Constants.Error)
			throw new UnexpectedResponseException(this.GetString(requestData), response);

		this.ParseError(results[1]);
		return false;
	}

	/// <summary>
	///		Sends the request to the Vndb Api by writing to the <see cref="Vndb.Stream"/>
	/// </summary>
	/// <param name="data"></param>
	/// <param name="cancellationToken"></param>
	/// <returns></returns>
	protected async Task SendDataAsync(Byte[] data, CancellationToken cancellationToken)
			=> await this.Stream.WriteAsync(data, 0, data.Length, cancellationToken).ConfigureAwait(false);

	/// <summary>
	///		Gets the response from the Vndb Api by reading to the <see cref="Vndb.Stream"/>
	/// </summary>
	/// <param name="cancellationToken">The CancellationToken used while reading and writing</param>
	/// <returns>The raw response as a String</returns>
	protected async Task<String> GetResponseAsync(CancellationToken cancellationToken)
	{
		this.LastError = null;
		this.LastErrorJson = String.Empty;

		var ms = new MemoryStream();
		var buffer = new Byte[this.ReceiveBufferSize];

		Int32 bytesRead;
		while ((bytesRead = await this.Stream.ReadAsync(buffer, 0, buffer.Length, cancellationToken).ConfigureAwait(false)) > 0)
		{
			await ms.WriteAsync(buffer, 0, bytesRead, cancellationToken).ConfigureAwait(false);
			if (buffer[--bytesRead] == Constants.EotChar)
				break;
		}

		using (ms)
		return this.GetString(ms.ToArray()).TrimEnd(Constants.EotChar);
	}

}

