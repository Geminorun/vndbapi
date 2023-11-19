package com.ymgal.model.Release;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/// <summary>
/// Release Information
/// </summary>
@Data
public class Release {
    /// <summary>
    /// Release ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Release Name
    /// </summary>
    @JsonProperty("title")
    public String Name;
    /// <summary>
    /// Release Original Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
    /// <summary>
    /// Date of Release
    /// </summary>
    public Date Released;
    /// <summary>
    /// Release Type
    /// </summary>
    public ReleaseType Type;
    /// <summary>
    /// Is the Release a patch
    /// </summary>
    @JsonProperty("patch")
    public Boolean IsPatch;
    /// <summary>
    /// Is the Release freeware
    /// </summary>
    @JsonProperty("freeware")
    public Boolean IsFreeware;
    /// <summary>
    /// Is the Release a doujin
    /// </summary>
    @JsonProperty("doujin")
    public Boolean IsDoujin;
    /// <summary>
    /// List of languages
    /// </summary>
    public List<String> Languages;
    /// <summary>
    /// Release Website
    /// </summary>
    public String Website;
    /// <summary>
    /// Release Notes
    /// </summary>
    public String Notes; // Possibly rename to description
    /// <summary>
    /// Minimum age
    /// </summary>
    @JsonProperty("minage")
    public Integer MinimumAge;
    /// <summary>
    ///		JAN/UPC/EAN code.
    /// </summary>
    public String Gtin;
    /// <summary>
    /// Catalog Number
    /// </summary>
    public String Catalog;
    /// <summary>
    /// Resolution of Release
    /// </summary>
    public String Resolution;
    /// <summary>
    /// Voiced Type
    /// </summary>
    public Voiced Voiced;
    /// <summary>
    ///		The array has two integer members, the first one indicating the story animations, the second the ero scene animations. Both members can be null if unknown or not applicable.
    /// </summary>
    public List<Animated> Animation;
    /// <summary>
    /// Release Platforms
    /// </summary>
    public List<String> Platforms;
    /// <summary>
    /// Release Media
    /// </summary>
    public List<Media> Media;
    /// <summary>
    /// Related Visual Novels
    /// </summary>
    @JsonProperty("vn")
    public List<VisualNovelMetadata> VisualNovels;
    /// <summary>
    /// Related Producers
    /// </summary>
    public List<ProducerRelease> Producers;
}

