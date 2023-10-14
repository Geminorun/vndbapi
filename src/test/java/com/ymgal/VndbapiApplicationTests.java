package com.ymgal;

import com.ymgal.api.VndbFilter;
import com.ymgal.api.model.Field;
import com.ymgal.api.model.FilterName;
import com.ymgal.api.model.FilterOperator;
import com.ymgal.api.model.PathPostfix;
import com.ymgal.service.INovelService;
import com.ymgal.service.impl.INovelServiceImpl;
import org.junit.jupiter.api.Test;


class VndbapiApplicationTests {

    public static INovelService iNovelService = new INovelServiceImpl();

    @Test
    void contextLoads() {
        //iNovelService.getNovelInfo();
        VndbFilter vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        iNovelService.getInfoApi(PathPostfix.VN, vndbFilter, Field.vn);
    }
}
