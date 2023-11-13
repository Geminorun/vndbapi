package com.ymgal.model.Dumps;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/// <summary>
/// Represents a Trait Object from the Traits Dump
/// </summary>
public class Trait {
    /// <summary>
    ///		The Id of the trait
    /// </summary>
    public Integer Id;
    /// <summary>
    ///		The name of the trait
    /// </summary>
    public String Name;
    /// <summary>
    ///		The description of the trait, which can include formatting codes described in http://vndb.org/d9.3
    /// </summary>
    public String Description;
    /// <summary>
    ///		The number of characters with this trait
    /// </summary>
    @JsonProperty("chars")
    public Integer Characters;
    /// <summary>
    ///		List of alternative names
    /// </summary>
    public List<String> Aliases;
    /// <summary>
    ///		List of parent traits (Empty if root)
    /// </summary>
    public List<Integer> Parents;
    /// <summary>
    ///		Whether this is a meta trait or not.
    /// </summary>
    @JsonProperty("meta")
    public Boolean IsMeta;
    /// <summary>
    /// Whether it's possible to filter characters by this trait.
    /// </summary>
    public Boolean IsSearchable;
    /// <summary>
    ///  	Whether this trait can be applied to character entries.
    /// </summary>
    public Boolean IsApplicable;
}
