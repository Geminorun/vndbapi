package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.SpoilerLevel;

/// <summary>
/// Tag Metadata
/// </summary>
public class TagMetadata {
    /// <summary>
    /// Tag Id
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Tag Score
    /// </summary>
    public Double Score;
    /// <summary>
    /// Tag Spoiler Level
    /// </summary>
    @JsonProperty("spoiler")
    public SpoilerLevel SpoilerLevel;

}
