package com.ymgal.model.Staff;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Visual Novels that the Staff worked on
/// </summary>
public class StaffVns {
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
    ///		The role they served as staff
    /// </summary>
    public String Role; // TODO: Convert to enum
    /// <summary>
    ///		Contains more info on their role as staff
    /// </summary>
    public String Note;
}

