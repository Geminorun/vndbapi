package com.ymgal.model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/// <summary>
/// User Lists
/// </summary>
@Data
public class UserList {
    /// <summary>
    /// User ID
    /// </summary>
    @JsonProperty("uid")
    public Integer UserId;
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    @JsonProperty("vn")
    public Integer VisualNovelId;
    /// <summary>
    /// Added on date
    /// </summary>
    @JsonProperty("added")
    public LocalDateTime AddedOn;
    /// <summary>
    /// Last modified date
    /// </summary>
    @JsonProperty("lastmod")
    public LocalDateTime LastModified;
    /// <summary>
    /// Voted on date
    /// </summary>
    @JsonProperty("voted")
    public LocalDateTime VotedOn;
    /// <summary>
    /// Current vote (between 10 and 100)
    /// </summary>
    public Integer Vote;
    /// <summary>
    /// Notes
    /// </summary>
    public String Notes;
    /// <summary>
    /// Started playing date
    /// </summary>
    public Date Started;
    /// <summary>
    /// Finished playing date
    /// </summary>
    public Date Finished;
    /// <summary>
    /// Collection of User Labels
    /// </summary>
    public List<UserLabels> Labels;

}

