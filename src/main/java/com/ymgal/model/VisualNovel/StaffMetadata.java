package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Staff Metadata
/// </summary>
public class StaffMetadata {
    /// <summary>
    /// Staff ID
    /// </summary>
    @JsonProperty("sid")
    public Integer StaffId;
    /// <summary>
    /// Alias ID
    /// </summary>
    @JsonProperty("aid")
    public Integer AliasId;
    /// <summary>
    /// English Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Japanese Name
    /// </summary>
    public String Kanji;
    /// <summary>
    ///		The role they served as staff
    /// </summary>
    public String Role; // TODO: Convert to enum
    /// <summary>
    ///		Contains more info on their role as staff
    /// </summary>
    public String Note;
    private StaffMetadata() {
    }
}

