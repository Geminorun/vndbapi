﻿package com.ymgal.model.Dumps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/// <summary>
///		Represents a Tag Object from the Tags Dump
/// </summary>
public class Tag {
    /// <summary>
    ///		The Id of the tag
    /// </summary>
    public Integer Id;
    /// <summary>
    ///		The name of the tag
    /// </summary>
    public String Name;
    /// <summary>
    ///		The description of the tag, which can include formatting codes described in http://vndb.org/d9.3
    /// </summary>
    public String Description;
    /// <summary>
    ///		Whether this is a meta tag or not. This field only exists for backwards compatibility and is currently the inverse of "searchable".
    /// </summary>
    @JsonProperty("meta")
    public Boolean IsMeta;
    /// <summary>
    /// Whether it's possible to filter VNs by this tag.
    /// </summary>
    public Boolean Searchable;
    /// <summary>
    /// Whether this tag can be applied to VN entries.
    /// </summary>
    public Boolean Applicable;
    /// <summary>
    ///		The number of Visual Novels with this tag
    /// </summary>
    @JsonProperty("vns")
    public Integer VisualNovels;
    /// <summary>
    ///		The category / Classification of the tag
    /// </summary>
    @JsonProperty("cat")
    public TagCategory TagCategory;
    /// <summary>
    ///		List of alternative names
    /// </summary>
    public List<String> Aliases;
    /// <summary>
    ///		List of parent Tags (Empty if Root Tag)
    /// </summary>
    public List<Integer> Parents;

}
