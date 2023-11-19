package com.ymgal.model.VisualNovel;

import com.ymgal.model.Common.ImageRating;
import lombok.Data;

/// <summary>
/// Screenshot Metadata
/// </summary>
@Data
public class ScreenshotMetadata {
    /// <summary>
    /// Image URL
    /// </summary>
    public String image;
    /// <summary>
    /// Release ID
    /// </summary>
    public Integer rid;
    /// <summary>
    /// Is Image NSFW
    /// </summary>
    public Boolean nsfw;
    /// <summary>
    /// Violence/Sexual rating of Image
    /// </summary>
    public ImageRating flagging;
    /// <summary>
    /// Image height in pixels
    /// </summary>
    public Integer height;
    /// <summary>
    /// Image width in pixels
    /// </summary>
    public Integer width;
}
