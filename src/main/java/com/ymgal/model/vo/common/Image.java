package com.ymgal.model.vo.common;

import lombok.Data;

@Data
public class Image {
    public Integer id;
    public String url;
    public Integer[] dims;
    public Integer sexual;
    public Integer violence;
    public Integer votecount;
}
