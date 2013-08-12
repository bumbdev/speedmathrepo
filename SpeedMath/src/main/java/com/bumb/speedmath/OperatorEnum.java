package com.bumb.speedmath;

/**
 * Created by manisharora on 8/10/13.
 */
public enum OperatorEnum {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("x"),
    DIVIDE("/"),
    PERCENT("%");

    private String operatorString;

    OperatorEnum(String operator) {
        operatorString = operator;
    }

    public String getOperatorString() {
        return operatorString;
    }
}
