package com.ymgal.service;

import com.ymgal.api.VndbFilter;
import com.ymgal.api.model.PathPostfix;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 09:13
 * @Description:
 */
public interface INovelService {

    public Object getNovelInfo();

    public Object getInfoApi(PathPostfix postfix, VndbFilter filter, String field);
}
