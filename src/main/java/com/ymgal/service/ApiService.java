package com.ymgal.service;


import com.ymgal.helper.HttpClientHelper;
import com.ymgal.helper.JsonHelper;
import com.ymgal.helper.PathPostfixHelper;
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
     * @return 泛型的java对象
     */
    public <T> T getInfoApi(PathPostfix postfix, VndbFilter filter) {

        //根据postfix获取tClass
        Class<?> tClass = PathPostfixHelper.getVoClass(postfix);
        //Class<?> tClass = Vn.class;
        //根据postfix获取fields
        String fields = PathPostfixHelper.getFields(postfix);

        //url赋值
        String url = baseurl + postfix.getPostfix();

        //body
        RequestBody body = new RequestBody();
        body.setFilters(filter.toFormatString());
        body.setFields(fields);

        //print
        System.out.println("Url " + url);
        System.out.println("Filter " + filter.toFormatString());
        System.out.println("Field " + fields);
        System.out.println("CLass " + tClass.getSimpleName());

        String jsonstr = HttpClientHelper.sendPost(url, JsonHelper.serialize(body));
        return JsonHelper.parse(jsonstr, (Class<T>) tClass);
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
