package com.ymgal.controller;

import com.ymgal.model.PathPostfix;
import com.ymgal.model.VndbFilter;
import com.ymgal.service.ApiService;

public class ApiController {

    ApiService apiService = new ApiService();

    public <T> T getInfo(PathPostfix postfix, VndbFilter filter, String field, Class<T> tClass) {


        //1.调用Service接口，获取VNDB数据，存入VN表中
        T t = apiService.getInfoApi(postfix, filter, field, tClass);

        //2.类型转化，将VN表转化为系统所需要的格式

        return t;
    }
}
