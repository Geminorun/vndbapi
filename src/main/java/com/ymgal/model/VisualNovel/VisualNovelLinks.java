package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.CommonLinks;

/// <summary>
/// Visual Novel Links
/// </summary>
public class VisualNovelLinks extends CommonLinks {
    /// <summary>
    /// Encubed Link
    /// </summary>
    @JsonProperty("encubed")
    public String Encubed;
    /// <summary>
    /// Renai Link
    /// </summary>
    @JsonProperty("renai")
    public String Renai;
}

