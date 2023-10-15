package com.ymgal.model;

import com.ymgal.dto.Archives;
import com.ymgal.model.vo.Vn;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 11:26
 * @Description:
 */

public enum PathPostfix {
    STATS("/stats"),
    USER("/user"),
    AUTHINFO("/authinfo"),
    VN("/vn"),
    RELEASE("/release"),
    PRODUCER("/producer"),
    CHARACTER("/character"),
    STAFF("/staff"),
    TAG("/tag"),
    TRAIT("/trait");


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
        Class cls = null;
        if ("/vn".equals(this.postfix)) {
            cls = Vn.class;
        }
        return cls;
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
