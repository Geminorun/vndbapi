package com.ymgal.model.VisualNovel;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Visual Novel Relations
/// </summary>
public class VisualNovelRelation {
    /// <summary>
    /// Visual Novel Id
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Relation Type
    /// </summary>
    @JsonProperty("relation")
    public RelationType Type;
    /// <summary>
    /// Title
    /// </summary>
    public String Title;
    /// <summary>
    /// Original Title
    /// </summary>
    public String Original;
    /// <summary>
    /// Is Official relation
    /// </summary>
    public Boolean Official;

}
