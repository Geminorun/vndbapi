package com.ymgal.model.Common;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Common Producer properties
/// </summary>
public class ProducerCommon {
    /// <summary>
    /// Producer ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Producer's Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Producer's Original/Official Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
    /// <summary>
    /// Type of the producer
    /// </summary>
    @JsonProperty("type")
    public String ProducerType; // Enum? Valid values - https://g.blicky.net/vndb.git/tree/util/sql/all.sql#n20 , real values???
}

