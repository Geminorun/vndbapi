package com.ymgal.model.Common;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Used for adding common links to link collections
/// </summary>
public class CommonLinks {
    /// <summary>
    /// Name of the related article on the English Wikipedia
    /// </summary>
    @Deprecated
    @JsonProperty("wikipedia")
    public String Wikipedia;
    /// <summary>
    /// Wikidata identifier
    /// </summary>
    @JsonProperty("wikidata")
    public String Wikidata;
}

