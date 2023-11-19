package com.ymgal.model.VisualNovel;

import lombok.Data;

import java.util.Date;

/// <summary>
/// Anime Metadata
/// </summary>
@Data
public class AnimeMetadata {
    /// <summary>
    /// AniDb ID
    /// </summary>
    public Integer id;
    /// <summary>
    /// AnimeNewsNetwork ID
    /// </summary>
    public Integer ann_id;
    /// <summary>
    /// AnimeNfo ID
    /// </summary>
    public String nfo_id;
    /// <summary>
    /// English Title
    /// </summary>
    public String title_romaji;
    /// <summary>
    /// Japanese Title
    /// </summary>
    public String title_kanji;
    /// <summary>
    /// Year anime aired
    /// </summary>
    public Date year;
    /// <summary>
    /// Anime Type
    /// </summary>
    public String type; // ??
}

