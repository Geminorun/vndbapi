package com.ymgal;

import com.ymgal.helper.JsonHelper;
import com.ymgal.model.PathPostfix;
import com.ymgal.model.ResponseBody;
import com.ymgal.model.VndbFilter;
import com.ymgal.model.enums.FilterName;
import com.ymgal.model.enums.FilterOperator;
import com.ymgal.model.vo.Release;
import com.ymgal.model.vo.Vn;
import com.ymgal.service.ApiService;
import org.junit.jupiter.api.Test;


class VndbapiApplicationTests {

    public static ApiService apiService = new ApiService();

    /**
     * @param: 获取VN档案
     * @return:
     * @auther: lyl
     * @date: 2023/10/16 15:03
     * 功能描述:
     */
    @Test
    void getVN() {
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        ResponseBody<Vn> responseBody = apiService.getInfoApi(PathPostfix.VN, vndbFilter);
        System.out.println(JsonHelper.serialize(responseBody.results.get(0)));
    }

    /**
     * @param: 获取发售信息
     * @return:
     * @auther: lyl
     * @date: 2023/10/16 15:03
     * 功能描述:
     */
    @Test
    void getRelease() {
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        ResponseBody<Release> responseBody = apiService.getInfoApi(PathPostfix.RELEASE, vndbFilter);
        System.out.println(JsonHelper.serialize(responseBody.results.get(0)));
    }


}
