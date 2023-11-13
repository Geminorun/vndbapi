package com.ymgal.model.Release;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Visual Novel Info related to Release
/// </summary>
public class VisualNovelMetadata {
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Visual Novel Name
    /// </summary>
    @JsonProperty("title")
    public String Name;
    /// <summary>
    /// Visaul Novel Original Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;

}
