package com.ymgal.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.SpoilerLevel;
import lombok.Data;

/// <summary>
/// List of instances of a character
/// </summary>
@Data
public class CharacterInstances {
    /// <summary>
    /// Character Id
    /// </summary>
    private Integer Id;
    /// <summary>
    /// Spoiler level
    /// </summary>
    private SpoilerLevel Spoiler;
    /// <summary>
    /// Character's Name
    /// </summary>
    private String Name;
    /// <summary>
    /// Character's Original/Japanese Name
    /// </summary>
    @JsonProperty("original")
    private String Kanji;
}

