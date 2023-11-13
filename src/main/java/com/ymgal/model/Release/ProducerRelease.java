package com.ymgal.model.Release;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ymgal.model.Common.ProducerCommon;

/// <summary>
/// Producer Involved in the Release
/// </summary>
public class ProducerRelease extends ProducerCommon {
    /// <summary>
    /// Is a developer
    /// </summary>
    public Boolean IsDeveloper;
    /// <summary>
    /// Is a publisher
    /// </summary>
    @JsonProperty("publisher")
    public Boolean IsPublisher;
}

