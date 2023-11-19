package com.ymgal.model.Staff;

import com.ymgal.model.Common.CommonLinks;
import lombok.Data;

/// <summary>
/// List of Staff Links
/// </summary>
@Data
public class StaffLinks extends CommonLinks {
    /// <summary>
    /// Official Homepage
    /// </summary>
    public String Homepage;
    /// <summary>
    /// Twitter page
    /// </summary>
    public String Twitter;
    /// <summary>
    /// AniDb page
    /// </summary>
    public String AniDb;
    /// <summary>
    /// Pixiv page
    /// </summary>
    public Integer Pixiv;
}

