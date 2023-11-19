package com.ymgal.model.VisualNovel;

import lombok.Data;

/// <summary>
/// Staff Metadata
/// </summary>
@Data
public class StaffMetadata {
    /// <summary>
    /// Staff ID
    /// </summary>
    public Integer sid;
    /// <summary>
    /// Alias ID
    /// </summary>
    public Integer aid;
    /// <summary>
    /// English Name
    /// </summary>
    public String name;

    /// <summary>
    /// Japanese Name
    /// </summary>
    public String original;
    /// <summary>
    ///		The role they served as staff
    /// </summary>
    public String role; // TODO: Convert to enum
    /// <summary>
    ///		Contains more info on their role as staff
    /// </summary>
    public String note;

    private StaffMetadata() {
    }
}

