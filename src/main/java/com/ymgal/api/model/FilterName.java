package com.ymgal.api.model;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 11:23
 * @Description:
 */
//public class FilterField {
//    public String id;
//    public String search;
//    public String lang;
//    public String olang;
//    public String type;
//    public String platform;
//    public String length;
//    public String released;
//    public String rating;
//    public String votecount;
//    public String has_description;
//    public String has_anime;
//    public String has_screenshot;
//    public String has_review;
//    public String devstatus;
//    public String tag;
//    public String dtag;
//    public String anime_id;
//    public String label;
//    public String release;
//    public String character;
//    public String staff;
//    public String developer;
//}
//

public enum FilterName {
    ID("id"),
    SEARCH("search"),
    LANG("lang"),
    OLANG("olang"),
    TYPE("type"),
    PLATFORM("platform"),
    LENGTH("length"),
    RELEASED("released"),
    RATING("rating"),
    VOTECOUNT("votecount"),
    HAS_DESCRIPTION("has_description"),
    HAS_ANIME("has_anime"),
    HAS_SCREENSHOT("has_screenshot"),
    HAS_REVIEW("has_review"),
    DEVSTATUS("devstatus"),
    TAG("tag"),
    DTAG("dtag"),
    ANIME_ID("anime_id"),
    LABEL("label"),
    RELEASE("release"),
    CHARACTER("character"),
    STAFF("staff"),
    DEVELOPER("developer");
    private String filterName;

    FilterName(String field) {
        this.filterName = field;
    }

    public static FilterName fromString(String field) {
        for (FilterName op : FilterName.values()) {
            if (op.filterName.equals(field)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid field: " + field);
    }

    public String getFilterName() {
        return this.filterName;
    }
}
