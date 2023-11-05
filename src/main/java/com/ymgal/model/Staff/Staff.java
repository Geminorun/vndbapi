package com.ymgal.model.Staff;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.Gender;

import java.util.List;

/// <summary>
/// Staff Information
/// </summary>
public class Staff {
    /// <summary>
    /// Staff Id
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Staff Name
    /// </summary>
    public String Name;
    /// <summary>
    /// Staff Original Name
    /// </summary>
    @JsonProperty("original")
    public String OriginalName;
    /// <summary>
    /// Staff Gender
    /// </summary>
    public Gender Gender;
    /// <summary>
    /// Primary Language
    /// </summary>
    public String Language;
    /// <summary>
    /// Related Staff links
    /// </summary>
    @JsonProperty("links")
    public StaffLinks StaffLinks;
    /// <summary>
    /// Staff Description
    /// </summary>
    public String Description;
    /// <summary>
    /// List of names and aliases
    /// </summary>
    public List<StaffAliases> Aliases;
    /// <summary>
    /// Main alias
    /// </summary>
    @JsonProperty("main_alias")
    public String MainAlias;
    /// <summary>
    /// Vns that the staff member has worked on
    /// </summary>
    public StaffVns[] Vns;
    /// <summary>
    /// List of Characters this staff has voiced
    /// </summary>
    public StaffVoiced[] Voiced;
}

