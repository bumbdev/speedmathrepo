package com.bumb.speedmath;

import static com.bumb.speedmath.RandomNumberGenerator.randomIntGenerator;

/**
 * Created by manisharora on 8/10/13.
 */
public class ProblemGenerator {

    private static int MIN_ONE_DIGIT = 1;
    private static int MAX_ONE_DIGIT = 10;
    private static int MIN_TWO_DIGIT = 10;
    private static int MAX_TWO_DIGIT = 100;
    private static int MIN_THREE_DIGIT = 100;
    private static int MAX_THREE_DIGIT = 1000;

    private static int oneDigitInt() {
        return randomIntGenerator(MIN_ONE_DIGIT, MAX_ONE_DIGIT);
    }

    private static double oneDigitOneDecimalDigitNumber() {
        return randomIntGenerator(MIN_TWO_DIGIT, MAX_TWO_DIGIT)/10.0;
    }

    private static int twoDigitInt() {
        return randomIntGenerator(MIN_TWO_DIGIT, MAX_TWO_DIGIT);
    }

    private static double twoDigitOneDecimalDigitNumber() {
        return randomIntGenerator(MIN_THREE_DIGIT, MAX_THREE_DIGIT)/10.0;
    }

    private static int threeDigitInt() {
        return randomIntGenerator(MIN_THREE_DIGIT, MAX_THREE_DIGIT);
    }

    private static Problem getProblemWithFirstDigitGreater(double x, double y, OperatorEnum operator, int score) {
        return (x > y) ? new Problem(x, y, operator, score) :
                new Problem(y, x, operator, score);
    }

    public static Problem getQuestion(ProblemTypeEnum problemType) {
        int score = problemType.getScore();
        switch (problemType) {
            case ONE_DIGIT_ADDITION:
                return new Problem(oneDigitInt(),oneDigitInt(), OperatorEnum.PLUS, score);
            case ONE_DIGIT_SUBTRACTION:
                return getProblemWithFirstDigitGreater(oneDigitInt(),oneDigitInt(),
                        OperatorEnum.MINUS, score);
            case ONE_DIGIT_MULTIPLICATION:
                return new Problem(oneDigitInt(), oneDigitInt(), OperatorEnum.MULTIPLY, score);
            case ONE_DIGIT_DIVISION_WITHOUT_DECIMAL_RESULT: /* Todo: Fix it */
            case ONE_DIGIT_DIVISION_WITH_DECIMAL_RESULT:
                return getProblemWithFirstDigitGreater(oneDigitInt(),oneDigitInt(), OperatorEnum.DIVIDE,
                        score);
            case TWO_DIGIT_ADDITION:
                return new Problem(twoDigitInt(), twoDigitInt(), OperatorEnum.PLUS, score);
            case ONE_DIGIT_ONE_DECIMAL_DIGIT_ADDITION:
                return new Problem(oneDigitOneDecimalDigitNumber(), oneDigitOneDecimalDigitNumber(),
                        OperatorEnum.PLUS, score);
            case TWO_DIGIT_SUBTRACTION:
                return getProblemWithFirstDigitGreater(twoDigitInt(), twoDigitInt(),
                        OperatorEnum.MINUS, score);
            case ONE_DIGIT_ONE_DECIMAL_DIGIT_SUBTRACTION:
                return getProblemWithFirstDigitGreater(oneDigitOneDecimalDigitNumber(),
                        oneDigitOneDecimalDigitNumber(), OperatorEnum.MINUS, score);
            case TWO_DIGIT_ONE_DIGIT_MULTIPLICATION:
                return new Problem(twoDigitInt(), oneDigitInt(), OperatorEnum.MULTIPLY, score);
            case TWO_DIGIT_ONE_DIGIT_DIVISION:
                return new Problem(twoDigitInt(), oneDigitInt(), OperatorEnum.DIVIDE, score);
            case THREE_DIGIT_TWO_DIGIT_ADDITION:
                return new Problem(threeDigitInt(), twoDigitInt(), OperatorEnum.PLUS, score);
            case THREE_DIGIT_ADDITION:
                return new Problem(threeDigitInt(), threeDigitInt(), OperatorEnum.PLUS, score);
            case THREE_DIGIT_TWO_DIGIT_SUBTRACTION:
                return new Problem(threeDigitInt(), twoDigitInt(), OperatorEnum.MINUS, score);
            case THREE_DIGIT_SUBTRACTION:
                return getProblemWithFirstDigitGreater(threeDigitInt(), threeDigitInt(),
                        OperatorEnum.MINUS, score);
            case TWO_DIGIT_ONE_DECIMAL_DIGIT_ADDITION:
                return new Problem(twoDigitOneDecimalDigitNumber(), twoDigitOneDecimalDigitNumber(),
                        OperatorEnum.PLUS, score);
            case TWO_DIGIT_ONE_DECIMAL_DIGIT_SUBTRACTION:
                return getProblemWithFirstDigitGreater(twoDigitOneDecimalDigitNumber(),
                        twoDigitOneDecimalDigitNumber(), OperatorEnum.MINUS, score);
            case TWO_DIGIT_MULTIPLICATION:
                return new Problem(twoDigitInt(), twoDigitInt(), OperatorEnum.MULTIPLY, score);
            default:
                throw new UnsupportedOperationException("This problem type is not supported");
        }
    }
}
