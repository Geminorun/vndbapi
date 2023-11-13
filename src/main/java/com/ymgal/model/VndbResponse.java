package com.ymgal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VndbResponse<T> {
    /// <summary>
    /// If there are more items available
    /// </summary>
    @JsonProperty("more")
    public Boolean HasMore;
    @JsonProperty("num")
    public Integer Count;
    /// <summary>
    /// Amount of items received
    /// </summary>
    /// <summary>
    /// Collection of entries. This is what holds the main data
    /// </summary>
    public List<T> Items;

    // Disable publicly constructing the Response Object
    private VndbResponse() {
    }
}

