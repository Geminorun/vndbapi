package com.ymgal.model;

import java.util.List;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 09:30
 * @Description:
 */

public class RequestBody {

    List<String> filters;

    String fields;

    public RequestBody() {
    }

    public List<String> getFilters() {
        return filters;
    }

    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
}
