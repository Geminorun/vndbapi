package com.ymgal.model.Character;

import com.ymgal.model.Common.SpoilerLevel;
import lombok.Data;

/// <summary>
/// Metadata about a particular Trait
/// </summary>
@Data
public class TraitMetadata {
    /// <summary>
    /// Trait ID
    /// </summary>
    public Integer Id;
    /// <summary>
    /// Spoiler level of Trait
    /// </summary>
    public SpoilerLevel SpoilerLevel;

    public TraitMetadata(Integer id, SpoilerLevel spoilerLevel) {
        Id = id;
        SpoilerLevel = spoilerLevel;
    }
}

