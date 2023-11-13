package com.ymgal.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.Priority;

import java.time.LocalDateTime;

/// <summary>
/// User Wishlist
/// </summary>
public class Wishlist {
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
    /// Wishlist Priority
    /// </summary>
    public Priority Priority;
    /// <summary>
    /// Added on Date
    /// </summary>
    @JsonProperty("added")
    public LocalDateTime AddedOn;
}

