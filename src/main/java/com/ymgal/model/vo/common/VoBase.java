package com.ymgal.model.vo.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Auther: lyl
 * @Date: 2023/10/16 11:37
 * @Description:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoBase {
    public String id;
}
