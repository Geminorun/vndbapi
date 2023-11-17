package com.ymgal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VndbResponse<T> {
    /// <summary>
    /// If there are more items available
    /// </summary>
    @JsonProperty("more")
    private Boolean HasMore;
    @JsonProperty("num")
    private Integer Count;
    /// <summary>
    /// Amount of items received
    /// </summary>
    /// <summary>
    /// Collection of entries. This is what holds the main data
    /// </summary>
    private List<T> Items;

    // Disable publicly constructing the Response Object
    private VndbResponse() {
    }
}

