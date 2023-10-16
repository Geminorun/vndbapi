package com.ymgal.model;

import com.ymgal.model.vo.common.VoBase;
import lombok.Data;

@Data
public class ResponseBody<T extends VoBase> {

    public Boolean more;

    public T results;
}
