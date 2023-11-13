package com.ymgal.model.Common;

import com.fasterxml.jackson.annotation.JsonProperty;

/// <summary>
/// Rating of the image (sexual and violence levels)
/// </summary>
public class ImageRating {
    /// <summary>
    /// Amount of votes for the rating
    /// </summary>
    @JsonProperty("votecount")
    public Integer VoteCount;
    /// <summary>
    /// Average of sexual rating, score between 0 and 2
    /// Levels are 0(Safe), 1(Suggestive), and 3(Explicit)
    /// </summary>
    @JsonProperty("sexual_avg")
    public Double SexualAvg;
    /// <summary>
    /// Average of violence rating, score between 0 and 2
    /// Levels are 0(Tame), 1(Violent), and 3(Brutal)
    /// </summary>
    @JsonProperty("violence_avg")
    public Double ViolenceAvg;
}
