package com.ymgal;

import com.ymgal.helper.JsonHelper;
import com.ymgal.model.VndbResponse;
import com.ymgal.modelhttp.PathPostfix;
import com.ymgal.modelhttp.VndbFilter;
import com.ymgal.modelhttp.enums.FilterName;
import com.ymgal.modelhttp.enums.FilterOperator;
import com.ymgal.modelhttp.vo.Release;
import com.ymgal.modelhttp.vo.Vn;
import org.junit.jupiter.api.Test;


class VndbapiApplicationTests {

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
        VndbResponse<Vn> responseBody = VndbGetMethodByHttp.getInfoApi(PathPostfix.VN, vndbFilter);
        System.out.println(JsonHelper.serialize(responseBody.getItems().get(0)));
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
        VndbResponse<Release> responseBody = VndbGetMethodByHttp.getInfoApi(PathPostfix.RELEASE, vndbFilter);
        System.out.println(JsonHelper.serialize(responseBody.getItems().get(0)));
    }


}
