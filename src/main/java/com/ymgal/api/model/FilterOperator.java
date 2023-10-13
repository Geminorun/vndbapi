package com.ymgal.api.model;

/**
 * @Auther: lyl
 * @Date: 2023/10/13 11:14
 * @Description:
 */
public enum FilterOperator {
    EQ("="),
    NE("!="),
    GT(">"),
    GTE(">="),
    LT("<"),
    LTE("<=");

    private String operator;

    FilterOperator(String operator) {
        this.operator = operator;
    }

    public static FilterOperator fromString(String operator) {
        for (FilterOperator op : FilterOperator.values()) {
            if (op.operator.equals(operator)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    public String getOperator() {
        return this.operator;
    }


}

//
//public class Operator {
//    @Value("=")
//    public static String eq;
//    @Value("!=")
//    public static String ne;
//    @Value(">")
//    public static String qt;
//    @Value(">=")
//    public static String gte;
//    @Value("<")
//    public static String lt;
//    @Value("<=")
//    public static String lte;
//}

