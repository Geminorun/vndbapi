package com.ymgal.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.Gender;
import com.ymgal.model.Common.ImageRating;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Character {
    /// <summary>
    /// Character's ID on Vndb
    /// </summary>
    private Integer Id;
    /// <summary>
    /// Character's Name
    /// </summary>
    private String Name;
    /// <summary>
    /// Character's Japanese/Original Name
    /// </summary>=
    @JsonProperty("original")
    private String OriginalName;
    /// <summary>
    /// Character's Gender
    /// </summary>
    private Gender Gender;
    /// <summary>
    /// Actual Sex, if the gender is a spoiler
    /// </summary>
    private Gender SpoilGender;
    /// <summary>
    /// Character's Gender
    /// </summary>
    @JsonProperty("bloodt")
    private BloodType BloodType;
    /// <summary>
    /// Character's Birthday
    /// </summary>
    private Date Birthday;
    /// <summary>
    /// Character's Aliases/Nicknames
    /// </summary>
    private List<String> Aliases;
    /// <summary>
    /// Description of the character
    /// </summary>
    private String Description;
    /// <summary>
    /// Character's age in years
    /// </summary>
    private Integer Age;
    /// <summary>
    /// Url Image of the character
    /// </summary>
    private String Image;
    /// <summary>
    /// Properties of the character's image. This determines how violent/sexual it is
    /// </summary>
    @JsonProperty("image_flagging")
    private ImageRating ImageRating;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    private Integer Bust;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    private Integer Waist;
    /// <summary>
    ///		Size in Centimeters
    /// </summary>
    private Integer Hip;
    /// <summary>
    ///		Height in Centimeters
    /// </summary>
    private Integer Height;
    /// <summary>
    ///		Weight in Kilograms
    /// </summary>
    private Integer Weight;
    /// <summary>
    /// CupSize of the character
    /// </summary>
    @JsonProperty("cup_size")
    private String CupSize;
    /// <summary>
    /// List of traits the character has
    /// </summary>
    private List<TraitMetadata> Traits;
    /// <summary>
    /// List of Visual Novels linked to this character
    /// </summary>
    @JsonProperty("vns")
    private List<VisualNovelMetadata> VisualNovels;
    /// <summary>
    /// List of voice actresses (staff) that voiced this character, per VN
    /// </summary>
    @JsonProperty("voiced")
    private List<VoiceActorMetadata> VoiceActorMetadata;
    /// <summary>
    /// List of instances of this character (excluding the character entry itself)
    /// </summary>
    @JsonProperty("instances")
    private List<CharacterInstances> CharacterInstances;


}
