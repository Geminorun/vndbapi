package com.ymgal.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.Gender;
import com.ymgal.model.Common.ImageRating;

import java.util.Date;
import java.util.List;

public class Character {
    /// <summary>
    /// Character's ID on Vndb
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Character's Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Character's Japanese/Original Name
    /// </summary>=
    @JsonProperty("original")
    public String OriginalName;
    /// <summary>
    /// Character's Gender
    /// </summary>
    public Gender Gender;
    /// <summary>
    /// Actual Sex, if the gender is a spoiler
    /// </summary>
    public Gender SpoilGender;
    /// <summary>
    /// Character's Gender
    /// </summary>
    @JsonProperty("bloodt")
    public BloodType BloodType;
    /// <summary>
    /// Character's Birthday
    /// </summary>
    public Date Birthday;
    /// <summary>
    /// Character's Aliases/Nicknames
    /// </summary>
    public List<String> Aliases;
    /// <summary>
    /// Description of the character
    /// </summary>
    public String Description;
    /// <summary>
    /// Character's age in years
    /// </summary>
    public Integer Age;
    /// <summary>
    /// Url Image of the character
    /// </summary>
    public String Image;
    /// <summary>
    /// Properties of the character's image. This determines how violent/sexual it is
    /// </summary>
    @JsonProperty("image_flagging")
    public ImageRating ImageRating;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    public Integer Bust;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    public Integer Waist;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    public Integer Hip;
    /// <summary>
    ///		Height in Centimeters
    /// </summary>
    public Integer Height;
    /// <summary>
    ///		Weight in Kilograms
    /// </summary>
    public Integer Weight;
    /// <summary>
    /// CupSize of the character
    /// </summary>
    @JsonProperty("cup_size")
    public String CupSize;
    /// <summary>
    /// List of traits the character has
    /// </summary>
    public List<TraitMetadata> Traits;
    /// <summary>
    /// List of Visual Novels linked to this character
    /// </summary>
    @JsonProperty("vns")
    public List<VisualNovelMetadata> VisualNovels;
    /// <summary>
    /// List of voice actresses (staff) that voiced this character, per VN
    /// </summary>
    @JsonProperty("voiced")
    public List<VoiceActorMetadata> VoiceActorMetadata;
    /// <summary>
    /// List of instances of this character (excluding the character entry itself)
    /// </summary>
    @JsonProperty("instances")
    public List<CharacterInstances> CharacterInstances;


}
