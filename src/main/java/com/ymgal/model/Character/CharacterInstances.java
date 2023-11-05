package com.ymgal.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.SpoilerLevel;

/// <summary>
/// List of instances of a character
/// </summary>
public class CharacterInstances {
    /// <summary>
    /// Character Id
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Spoiler level
    /// </summary>
    public SpoilerLevel Spoiler;
    /// <summary>
    /// Character's Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Character's Original/Japanese Name
    /// </summary>
    @JsonProperty("original")
    public String Kanji;
}

