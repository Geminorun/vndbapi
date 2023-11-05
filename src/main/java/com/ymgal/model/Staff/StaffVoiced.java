package com.ymgal.model.Staff;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Characters the staff has voiced
/// </summary>
public class StaffVoiced {
    /// <summary>
    /// Staff Id
    /// </summary>
    @JsonProperty("id")
    public Integer StaffId;
    /// <summary>
    /// Alias Id
    /// </summary>
    @JsonProperty("aid")
    public Integer AliasId;
    /// <summary>
    /// Character Id
    /// </summary>
    @JsonProperty("cid")
    public Integer CharacterId;
    /// <summary>
    /// Notes
    /// </summary>
    public String Note;
}

