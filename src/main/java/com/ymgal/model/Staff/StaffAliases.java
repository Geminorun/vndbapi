package com.ymgal.model.Staff;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Staff Aliases
/// </summary>
public class StaffAliases {
    /// <summary>
    /// Staff Id
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Staff Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Staff Original Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
}

