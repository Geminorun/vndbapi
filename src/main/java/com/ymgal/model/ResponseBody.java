package com.ymgal.model;

import lombok.Data;

@Data
public class ResponseBody<T> {

    public Boolean more;

    public T results;

}
