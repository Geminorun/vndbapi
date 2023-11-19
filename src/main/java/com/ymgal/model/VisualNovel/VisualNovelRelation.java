package com.ymgal.model.VisualNovel;

import lombok.Data;

/// <summary>
/// Visual Novel Relations
/// </summary>
@Data
public class VisualNovelRelation {
    /// <summary>
    /// Visual Novel Id
    /// </summary>
    public Integer id;
    /// <summary>
    /// Relation Type
    /// </summary>
    public String relation;
    /// <summary>
    /// Title
    /// </summary>
    public String title;
    /// <summary>
    /// Original Title
    /// </summary>
    public String original;
    /// <summary>
    /// Is Official relation
    /// </summary>
    public Boolean official;

}
