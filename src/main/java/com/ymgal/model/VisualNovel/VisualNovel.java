package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.ImageRating;
import lombok.Data;

import java.util.Date;
import java.util.List;

/// <summary>
/// Visual Novel Info
/// </summary>
@Data
public class VisualNovel {
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    private Integer Id;
    /// <summary>
    /// Vn Name
    /// </summary>
    @JsonProperty("title")
    private String Name;
    /// <summary>
    /// Vn Original Name
    /// </summary>
    @JsonProperty("original")
    private String OriginalName;
    /// <summary>
    /// Release Date
    /// </summary>
    private Date Released; // Release or Released?
    /// <summary>
    /// List of available languages
    /// </summary>
    private List<String> Languages;
    /// <summary>
    /// languages of the first release
    /// </summary>
    @JsonProperty("orig_lang")
    private List<String> OriginalLanguages;
    /// <summary>
    /// List of platforms released on
    /// </summary>
    private List<String> Platforms;
    /// <summary>
    /// List of aliases for the game
    /// </summary>
    private List<String> Aliases;
    /// <summary>
    /// Estimated length of the game
    /// </summary>
    private VisualNovelLength Length;
    /// <summary>
    /// Description of the game. Can include formatting codes
    /// </summary>
    private String Description;
    /// <summary>
    /// Links related to this game
    /// </summary>
    @JsonProperty("links")
    private VisualNovelLinks VisualNovelLinks;
    /// <summary>
    /// Cover Image URL
    /// </summary>
    private String Image;
    /// <summary>
    /// Is Image NSFW
    /// </summary>
    @JsonProperty("image_nsfw")
    private Boolean IsImageNsfw;
    /// <summary>
    /// Violence/Sexual rating of the cover image
    /// </summary>
    @JsonProperty("image_flagging")
    private ImageRating ImageRating;
    /// <summary>
    /// List of related Anime
    /// </summary>
    private List<AnimeMetadata> Anime;
    /// <summary>
    /// List of related games
    /// </summary>
    private List<VisualNovelRelation> Relations;
    /// <summary>
    /// List of associated Tags
    /// </summary>
    private List<TagMetadata> Tags;
    /// <summary>
    /// Popularity of the game (between 0 and 100)
    /// </summary>
    private Double Popularity;
    /// <summary>
    /// Bayesian rating of the game (between 1 and 10)
    /// </summary>
    private double Rating;
    /// <summary>
    /// List of associated Screenshots
    /// </summary>
    @JsonProperty("screens")
    private List<ScreenshotMetadata> Screenshots;
    /// <summary>
    /// List of associated Staff
    /// </summary>
    private List<StaffMetadata> Staff;

    private VisualNovel() {
    }
}

