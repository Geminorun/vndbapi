package com.ymgal.model.Common;

import lombok.Data;

/// <summary>
/// Used for adding common links to link collections
/// </summary>
@Data
public class CommonLinks {
    /// <summary>
    /// Name of the related article on the English Wikipedia
    /// </summary>
    @Deprecated
    public String wikipedia;
    /// <summary>
    /// Wikidata identifier
    /// </summary>
    public String wikidata;
}

