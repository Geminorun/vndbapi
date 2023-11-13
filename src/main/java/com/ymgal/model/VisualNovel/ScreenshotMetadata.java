package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.ImageRating;

/// <summary>
/// Screenshot Metadata
/// </summary>
public class ScreenshotMetadata {
    /// <summary>
    /// Image URL
    /// </summary>
    @JsonProperty("image")
    public String Url;
    /// <summary>
    /// Release ID
    /// </summary>
    @JsonProperty("rid")
    public String ReleaseId;
    /// <summary>
    /// Is Image NSFW
    /// </summary>
    @JsonProperty("nsfw")
    public Boolean IsNsfw;
    /// <summary>
    /// Violence/Sexual rating of Image
    /// </summary>
    @JsonProperty("flagging")
    public ImageRating ImageRating;
    /// <summary>
    /// Image height in pixels
    /// </summary>
    public Integer Height;
    /// <summary>
    /// Image width in pixels
    /// </summary>
    public Integer Width;
}
