package com.ymgal.service;


import com.ymgal.helper.HttpClientHelper;
import com.ymgal.helper.JsonHelper;
import com.ymgal.model.PathPostfix;
import com.ymgal.model.RequestBody;
import com.ymgal.model.VndbFilter;
import com.ymgal.model.enums.FilterName;
import com.ymgal.model.enums.FilterOperator;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 09:13
 * @Description:
 */

public class ApiService {


    private final static String baseurl = "https://api.vndb.org/kana";

    /**
     * 请求VNDB接口，将返回的json转化为java对象
     *
     * @param postfix 枚举  URL后缀。如：https://api.vndb.org/kana/vn 中的/vn
     * @param filter  过滤器  如：id = 17
     * @param field   返回字段
     * @return 泛型的java对象
     */
    public <T> T getInfoApi(PathPostfix postfix, VndbFilter filter, String field, Class<T> tClass) {

        //根据postfix获取tClass
//        Class tClass = postfix.getVoClass();

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

        String jsonstr = HttpClientHelper.sendPost(url, JsonHelper.serialize(body));
        return JsonHelper.parse(jsonstr, tClass);
    }

    public Object getNovelInfo() {
        String url = baseurl + "/vn";

        RequestBody body = new RequestBody();
        body.setFilters(new VndbFilter(FilterName.ID.getFilterName(), FilterOperator.EQ.getOperator(), "v17").toFormatString());
        body.setFields("Title,image.url");

        Object obj = HttpClientHelper.sendPost(url, JsonHelper.serialize(body));
        return obj;
    }

}
