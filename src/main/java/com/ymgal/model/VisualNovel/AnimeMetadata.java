package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/// <summary>
/// Anime Metadata
/// </summary>
public class AnimeMetadata {
    /// <summary>
    /// AniDb ID
    /// </summary>
    @JsonProperty("id")
    public Integer AniDbId;
    /// <summary>
    /// AnimeNewsNetwork ID
    /// </summary>
    @JsonProperty("ann_id")
    public Integer AnimeNewsNetworkId;
    /// <summary>
    /// AnimeNfo ID
    /// </summary>
    @JsonProperty("nfo_id")
    public String AnimeNfoId;
    /// <summary>
    /// English Title
    /// </summary>
    @JsonProperty("title_romaji")
    public String RomajiTitle;
    /// <summary>
    /// Japanese Title
    /// </summary>
    @JsonProperty("title_kanji")
    public String KanjiTitle;
    /// <summary>
    /// Year anime aired
    /// </summary>
    @JsonProperty("year")
    public Date AiringYear;
    /// <summary>
    /// Anime Type
    /// </summary>
    @JsonProperty("type")
    public String Type; // ??
}

