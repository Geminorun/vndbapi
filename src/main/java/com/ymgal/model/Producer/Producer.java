package com.ymgal.model.Producer;

import com.ymgal.model.Common.ProducerCommon;
import lombok.Data;

import java.util.List;

/// <summary>
/// Producer Information
/// </summary>
@Data
public class Producer extends ProducerCommon {
    /// <summary>
    /// Primary Language
    /// </summary>
    public String Language;
    /// <summary>
    /// Producer Links
    /// </summary>
    public ProducerLinks Links;
    /// <summary>
    /// List of alternative names
    /// </summary>
    public List<String> Aliases;
    /// <summary>
    /// Description/notes of the producer, can contain formatting codes
    /// </summary>
    public String Description;
    /// <summary>
    /// List of related producers
    /// </summary>
    public List<Relationship> Relations;
}

