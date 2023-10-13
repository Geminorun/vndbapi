package com.ymgal.service.impl;


import com.ymgal.api.VndbFilter;
import com.ymgal.api.model.FilterName;
import com.ymgal.api.model.FilterOperator;
import com.ymgal.api.model.PathPostfix;
import com.ymgal.helper.HttpClientHelper;
import com.ymgal.helper.JsonHelper;
import com.ymgal.model.RequestBody;
import com.ymgal.service.INovelService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 09:13
 * @Description:
 */
@Service
public class INovelServiceImpl implements INovelService {

    @Value("${vndb.url}")
    private String baseurl;

    @Override
    public Object getNovelInfo() {
        String url = baseurl + "/vn";

        RequestBody body = new RequestBody();
        body.setFilters(new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "v17").toFormatString());
        body.setFields("title,image.url");

        Object obj = HttpClientHelper.sendPost(url, JsonHelper.serialize(body));

        System.out.println(obj);
        return 0;
    }

    @Override
    public Object getInfoApi(PathPostfix postfix, VndbFilter filter, String field) {

        //url赋值
        String url = baseurl + postfix.getPostfix();

        //body
        RequestBody body = new RequestBody();
        body.setFilters(filter.toFormatString());
        body.setFields(field);

        //print
        System.out.println("Url " + url);
        System.out.println("Filter " + filter.toFormatString());
        System.out.println("Field " + field);

        Object obj = HttpClientHelper.sendPost(url, JsonHelper.serialize(body));
        System.out.println(obj);
        return obj;
        
    }

}
