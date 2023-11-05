﻿package com.ymgal.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.Status;

import java.time.LocalDateTime;

/// <summary>
/// List of VNs on a user's list
/// </summary>
public class VisualNovelList {
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    @JsonProperty("vn")
    public Integer VisualNovelId;
    /// <summary>
    /// User ID
    /// </summary>
    @JsonProperty("uid")
    public Integer UserId;
    /// <summary>
    /// Visual Novel Status
    /// </summary>
    public Status Status;
    /// <summary>
    /// Added on Date
    /// </summary>
    @JsonProperty("added")
    public LocalDateTime AddedOn;
    /// <summary>
    /// Notes
    /// </summary>
    public String Notes;
}

