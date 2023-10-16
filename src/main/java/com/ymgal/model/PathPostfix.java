package com.ymgal.model;

import com.ymgal.dto.Archives;
import com.ymgal.model.enums.Field;
import com.ymgal.model.vo.Character;
import com.ymgal.model.vo.Producer;
import com.ymgal.model.vo.Release;
import com.ymgal.model.vo.Vn;
import com.ymgal.model.vo.common.VoBase;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 11:26
 * @Description:
 */

public enum PathPostfix {
    STATS("/stats"), USER("/user"), AUTHINFO("/authinfo"), VN("/vn"), RELEASE("/release"), PRODUCER("/producer"), CHARACTER("/character"), STAFF("/staff"), TAG("/tag"), TRAIT("/trait");


    private final String postfix;

    PathPostfix(String postfix) {
        this.postfix = postfix;
    }

    public static PathPostfix fromString(String postfix) {
        for (PathPostfix op : PathPostfix.values()) {
            if (op.postfix.equals(postfix)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid postfix: " + postfix);
    }

    public Class getVoClass() {

//        Result<String> result = new Result<>(String.class);
//        Class<?> resultClass = result.getType();

        Class<?> cls = null;

        switch (this.postfix) {
            case "/vn":
                cls = (new ResponseBody<Vn>()).getClass();
                break;
            case "/release":
                cls = (new ResponseBody<Release>()).getClass();
                break;
            case "/character":
                cls = (new ResponseBody<Character>()).getClass();
                break;
            case "/producer":
                cls = (new ResponseBody<Producer>()).getClass();
                break;
            default:
                cls = (new ResponseBody<VoBase>()).getClass();
                break;
        }
        return cls;
    }

    public String getFields() {
        String fields = "";

        switch (this.postfix) {
            case "/vn":
                fields = Field.vn;
                break;
            case "/release":
                fields = Field.release;
                break;
            case "/character":
                fields = Field.character;
                break;
            case "/producer":
                fields = Field.producer;
                break;
            default:
                fields = "id";
                break;
        }
        return fields;
    }

    public Class getDtoClass() {
        Class cls = null;
        if ("/vn".equals(this.postfix)) {
            cls = Archives.class;
        }
        return cls;
    }


    public String getPostfix() {
        return this.postfix;
    }
}
