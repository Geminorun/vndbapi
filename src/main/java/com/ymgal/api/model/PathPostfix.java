package com.ymgal.api.model;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 11:26
 * @Description:
 */

//public class Postfix {
//    public static String stats;
//    public static String user;
//    public static String authinfo;
//    public static String vn;
//    public static String release;
//}

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


    private String postfix;

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

    public String getPostfix() {
        return this.postfix;
    }
}
