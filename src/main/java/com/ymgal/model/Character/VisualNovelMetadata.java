package com.ymgal.model.Character;

import com.ymgal.model.Common.SpoilerLevel;

/// <summary>
/// Metadata about a VN
/// </summary>
public class VisualNovelMetadata {
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Visual Novel Release ID
    /// </summary>
    public Integer ReleaseId;
    /// <summary>
    /// Visual Novel Spoiler Level
    /// </summary>
    public SpoilerLevel SpoilerLevel;
    /// <summary>
    /// Character Role
    /// </summary>
    public CharacterRole Role;
    protected VisualNovelMetadata(Integer Id, Integer ReleaseId, SpoilerLevel spoilerLevel, CharacterRole characterRole) {
        this.Id = Id;
        this.ReleaseId = ReleaseId;
        this.SpoilerLevel = spoilerLevel;
        this.Role = characterRole;
    }
}

