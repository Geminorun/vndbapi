package com.ymgal.model.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/// <summary>
/// Metadata about a voice actor
/// </summary>
@Data
public class VoiceActorMetadata {
    /// <summary>
    /// Staff Id
    /// </summary>
    @JsonProperty("id")
    public Integer StaffId;
    /// <summary>
    /// Staff Alias ID
    /// </summary>
    @JsonProperty("aid")
    public Integer AliasId;
    /// <summary>
    /// Visual Novel ID
    /// </summary>
    @JsonProperty("vid")
    public Integer VisualNovelId;
    /// <summary>
    /// Notes
    /// </summary>
    public String Note;
}

