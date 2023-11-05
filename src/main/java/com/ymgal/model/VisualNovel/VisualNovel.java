package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.ImageRating;

import java.util.Date;
import java.util.List;

/// <summary>
/// Visual Novel Info
/// </summary>
public class VisualNovel {
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Vn Name
    /// </summary>
    @JsonProperty("title")
    public String Name;
    /// <summary>
    /// Vn Original Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
    /// <summary>
    /// Release Date
    /// </summary>
    public Date Released; // Release or Released?
    /// <summary>
    /// List of available languages
    /// </summary>
    public List<String> Languages;
    /// <summary>
    /// languages of the first release
    /// </summary>
    @JsonProperty("orig_lang")
    public List<String> OriginalLanguages;
    /// <summary>
    /// List of platforms released on
    /// </summary>
    public List<String> Platforms;
    /// <summary>
    /// List of aliases for the game
    /// </summary>
    public List<String> Aliases;
    /// <summary>
    /// Estimated length of the game
    /// </summary>
    public VisualNovelLength Length;
    /// <summary>
    /// Description of the game. Can include formatting codes
    /// </summary>
    public String Description;
    /// <summary>
    /// Links related to this game
    /// </summary>
    @JsonProperty("links")
    public VisualNovelLinks VisualNovelLinks;
    /// <summary>
    /// Cover Image URL
    /// </summary>
    public String Image;
    /// <summary>
    /// Is Image NSFW
    /// </summary>
    @JsonProperty("image_nsfw")
    public Boolean IsImageNsfw;
    /// <summary>
    /// Violence/Sexual rating of the cover image
    /// </summary>
    @JsonProperty("image_flagging")
    public ImageRating ImageRating;
    /// <summary>
    /// List of related Anime
    /// </summary>
    public List<AnimeMetadata> Anime;
    /// <summary>
    /// List of related games
    /// </summary>
    public List<VisualNovelRelation> Relations;
    /// <summary>
    /// List of associated Tags
    /// </summary>
    public List<TagMetadata> Tags;
    /// <summary>
    /// Popularity of the game (between 0 and 100)
    /// </summary>
    public Double Popularity;
    /// <summary>
    /// Bayesian rating of the game (between 1 and 10)
    /// </summary>
    public double Rating;
    /// <summary>
    /// List of associated Screenshots
    /// </summary>
    @JsonProperty("screens")
    public List<ScreenshotMetadata> Screenshots;
    /// <summary>
    /// List of associated Staff
    /// </summary>
    public List<StaffMetadata> Staff;
    private VisualNovel() {
    }
}

