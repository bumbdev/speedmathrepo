package com.bumb.speedmath;

/**
 * Created by manisharora on 8/10/13.
 */
public class Problem {
    private double x;
    private double y;
    private OperatorEnum  operator;
    private double result;
    private int score;

    Problem(double x, double y, OperatorEnum operator, int score) {
        this.x = x;
        this.y = y;
        this.operator = operator;
        this.score = score;
        calculateResult();
    }

    private void calculateResult() {
        switch (this.operator) {
            case PLUS:
                this.result = x + y;
                break;
            case MINUS:
                this.result = x - y;
                break;
            case MULTIPLY:
                this.result = x * y;
                break;
            case DIVIDE:
                this.result = x / y;
                break;
        }
    }

    public double getResult() {
        return result;
    }

    public String getProblemStatement() {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        builder.append(" ");
        builder.append(operator.getOperatorString());
        builder.append(" ");
        builder.append(y);
        String problemStatement = builder.toString();
        problemStatement = problemStatement.replace(".0","");
        System.out.println("Problem: " + x + " " + y + " statement:" + problemStatement);
        return problemStatement;
    }

    public int getScore() {
        return this.score;
    }
}
