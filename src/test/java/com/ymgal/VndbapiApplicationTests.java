package com.ymgal;

import com.ymgal.helper.JsonHelper;
import com.ymgal.model.PathPostfix;
import com.ymgal.model.ResponseBody;
import com.ymgal.model.VndbFilter;
import com.ymgal.model.enums.FilterName;
import com.ymgal.model.enums.FilterOperator;
import com.ymgal.model.vo.Character;
import com.ymgal.service.ApiService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class VndbapiApplicationTests {

    public static ApiService apiService = new ApiService();

    @Test
    void contextLoads() {
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        ResponseBody<Character> responseBody = apiService.getInfoApi(PathPostfix.CHARACTER, vndbFilter);
        System.out.println(JsonHelper.serialize(responseBody));
    }


    @Test
    void practice() {
        List<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,24");
        list.add("wangwu,25");

        List<String> collect = list.stream().filter(x -> Integer.parseInt(x.split(",")[1]) >= 24).collect(Collectors.toList());
        System.out.println(collect);

    }
}
