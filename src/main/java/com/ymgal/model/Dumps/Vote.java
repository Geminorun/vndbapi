package com.ymgal.model.Dumps;

import java.util.Date;

/// <summary>
/// Vote Object from the Dump
/// </summary>
public class Vote {
    /// <summary>
    /// Version of the Dump
    /// </summary>
    public VoteDumpVersion Version;
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    public Integer VisualNovelId;
    /// <summary>
    /// User ID
    /// </summary>
    public Integer UserID;
    /// <summary>
    /// Vote Value (Between 10 and 100)
    /// </summary>
    public Byte Value;
    /// <summary>
    /// Date the vote was added on
    /// </summary>
    public Date AddedOn;

    protected Vote(VoteDumpVersion version, Integer visualNovelId, Integer userId, Byte value, Date addedOn) {
        this.Version = version;
        this.VisualNovelId = visualNovelId;
        this.UserID = userId;
        this.Value = value;
        this.AddedOn = addedOn;
    }
}

