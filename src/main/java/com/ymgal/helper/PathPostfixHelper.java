package com.ymgal.helper;

import com.ymgal.model.PathPostfix;
import com.ymgal.model.ResponseBody;
import com.ymgal.model.enums.Field;
import com.ymgal.model.vo.Character;
import com.ymgal.model.vo.Producer;
import com.ymgal.model.vo.Release;
import com.ymgal.model.vo.Vn;
import com.ymgal.model.vo.common.VoBase;

/**
 * @Auther: lyl
 * @Date: 2023/10/16 14:34
 * @Description:
 */
public class PathPostfixHelper {

    public static Class getVoClass(PathPostfix pathPostfix) {
        Class<?> cls = null;

        switch (pathPostfix) {
            case VN:
                cls = (new ResponseBody<Vn>()).getClass();
                break;
            case RELEASE:
                cls = (new ResponseBody<Release>()).getClass();
                break;
            case CHARACTER:
                cls = (new ResponseBody<Character>()).getClass();
                break;
            case PRODUCER:
                cls = (new ResponseBody<Producer>()).getClass();
                break;
            default:
                cls = (new ResponseBody<VoBase>()).getClass();
                break;
        }
        return cls;
    }

    public static String getFields(PathPostfix pathPostfix) {
        String fields = "";

        switch (pathPostfix) {
            case VN:
                fields = Field.vn;
                break;
            case RELEASE:
                fields = Field.release;
                break;
            case CHARACTER:
                fields = Field.character;
                break;
            case PRODUCER:
                fields = Field.producer;
                break;
            default:
                fields = "id";
                break;
        }
        return fields;
    }

}
