package com.ymgal.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBody<T> {

    public Boolean more;

    public List<T> results;
}
