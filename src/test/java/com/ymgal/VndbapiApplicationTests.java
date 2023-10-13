package com.ymgal;

import com.ymgal.api.VndbFilter;
import com.ymgal.api.model.Field;
import com.ymgal.api.model.FilterName;
import com.ymgal.api.model.FilterOperator;
import com.ymgal.api.model.PathPostfix;
import com.ymgal.service.INovelService;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VndbapiApplicationTests {

    @Autowired
    INovelService iNovelService;

    @Test
    void contextLoads() {
        //iNovelService.getNovelInfo();
        val vndbFilter = new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "17");
        iNovelService.getInfoApi(PathPostfix.VN, vndbFilter, Field.vn);
    }
}
