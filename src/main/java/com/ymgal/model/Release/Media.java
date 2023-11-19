package com.ymgal.model.Release;

import lombok.Data;

/// <summary>
/// Release media type (DVD, internet,...)
/// </summary>
@Data
public class Media {
    /// <summary>
    /// Medium Type
    /// </summary>
    public String Medium;
    /// <summary>
    /// Quantity of the medium
    /// </summary>
    public Integer Quantity;
}

