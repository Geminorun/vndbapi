package com.ymgal.model.Producer;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Producer Relation info
/// </summary>
public class Relationship {
    /// <summary>
    /// Producer ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Relation to the current producer
    /// </summary>
    public String Relation; // TODO: Enum?
    /// <summary>
    /// Producer name
    /// </summary>
    public String Name;
    /// <summary>
    /// Original name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
}
