package com.ymgal.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/// <summary>
/// User VoteList
/// </summary>
@Data
public class VoteList {
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
    /// Current Vote (between 10 and 100)
    /// </summary>
    public Integer Vote;
    /// <summary>
    /// Added on Date
    /// </summary>
    @JsonProperty("added")
    public LocalDateTime AddedOn;
}

