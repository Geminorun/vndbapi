package com.ymgal.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/// <summary>
/// User Labels
/// </summary>
@Data
public class UserLabels {
    /// <summary>
    /// User ID
    /// </summary>
    @JsonProperty("uid")
    public Integer UserId;
    /// <summary>
    /// Label ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Label Name
    /// </summary>
    public String Label;
    /// <summary>
    /// Is Label private
    /// </summary>
    @JsonProperty("private")
    public Boolean IsPrivate;
}

