package com.bumb.speedmath;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manisharora on 8/11/13.
 */
public class LevelOne extends Level {

    private List<Stage> stages;
    private ArrayList<Problem> problems;
    private int currentProblemNumber = 0;

    @Override
    public int getNumberOfStages() {
        return this.stages.size();
    }

    @Override
    public int getNumberOfProblems() {
        return this.problems.size();
    }

    public LevelOne() {
        this.stages = new ArrayList<Stage>();
        this.problems = new ArrayList<Problem>();
        currentProblemNumber = 0;
        generateStages();
        generateProblems();
    }

    private void generateStages() {
        Stage stage1 = new Stage(10);
        stage1.addProblemType(ProblemTypeEnum.ONE_DIGIT_ADDITION, 25);
        stage1.addProblemType(ProblemTypeEnum.ONE_DIGIT_SUBTRACTION, 25);
        stage1.addProblemType(ProblemTypeEnum.ONE_DIGIT_MULTIPLICATION, 25);
        stage1.addProblemType(ProblemTypeEnum.ONE_DIGIT_DIVISION_WITH_DECIMAL_RESULT, 12);
        stage1.addProblemType(ProblemTypeEnum.ONE_DIGIT_DIVISION_WITHOUT_DECIMAL_RESULT, 13);

        Stage stage2 = new Stage(3);
        stage2.addProblemType(ProblemTypeEnum.TWO_DIGIT_ADDITION, 50);
        stage2.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_ADDITION, 50);

        Stage stage3 = new Stage(3);
        stage3.addProblemType(ProblemTypeEnum.TWO_DIGIT_SUBTRACTION, 50);
        stage3.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_SUBTRACTION, 50);

        Stage stage4 = new Stage(3);
        stage4.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DIGIT_MULTIPLICATION, 100);

        Stage stage5 = new Stage(6);
        stage5.addProblemType(ProblemTypeEnum.TWO_DIGIT_ADDITION, 16);
        stage5.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_ADDITION, 16);
        stage5.addProblemType(ProblemTypeEnum.TWO_DIGIT_SUBTRACTION, 16);
        stage5.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_SUBTRACTION, 16);
        stage5.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DIGIT_MULTIPLICATION, 16);
        stage5.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DIGIT_DIVISION, 20);

        Stage stage6 = new Stage(3);
        stage6.addProblemType(ProblemTypeEnum.THREE_DIGIT_ADDITION, 34);
        stage6.addProblemType(ProblemTypeEnum.THREE_DIGIT_TWO_DIGIT_ADDITION, 33);
        stage6.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DECIMAL_DIGIT_ADDITION, 33);

        Stage stage7 = new Stage(2);
        stage7.addProblemType(ProblemTypeEnum.TWO_DIGIT_MULTIPLICATION, 50);
        stage7.addProblemType(ProblemTypeEnum.THREE_DIGIT_SUBTRACTION, 50);

        Stage stage8 = new Stage(90);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_ADDITION, 2);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_SUBTRACTION, 2);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_MULTIPLICATION, 2);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_DIVISION_WITH_DECIMAL_RESULT, 2);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_DIVISION_WITHOUT_DECIMAL_RESULT, 2);

        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_ADDITION, 10);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_ADDITION, 10);
        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_SUBTRACTION, 10);
        stage8.addProblemType(ProblemTypeEnum.ONE_DIGIT_ONE_DECIMAL_DIGIT_SUBTRACTION, 10);
        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DIGIT_MULTIPLICATION, 11);
        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DIGIT_DIVISION, 12);

        stage8.addProblemType(ProblemTypeEnum.THREE_DIGIT_ADDITION, 3);
        stage8.addProblemType(ProblemTypeEnum.THREE_DIGIT_TWO_DIGIT_ADDITION, 3);
        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_ONE_DECIMAL_DIGIT_ADDITION, 3);
        stage8.addProblemType(ProblemTypeEnum.TWO_DIGIT_MULTIPLICATION, 3);
        stage8.addProblemType(ProblemTypeEnum.THREE_DIGIT_SUBTRACTION, 5);

        this.stages.add(stage1);
        this.stages.add(stage2);
        this.stages.add(stage3);
        this.stages.add(stage4);
        this.stages.add(stage5);
        this.stages.add(stage6);
        this.stages.add(stage7);
        this.stages.add(stage8);
    }

    private void generateProblems() {
        for(Stage stage : this.stages) {
            List<Problem> stageProblems = stage.getProblems();
            for (Problem problem : stageProblems) {
                this.problems.add(problem);
            }
        }
    }

    @Override
    public ArrayList<Problem> getProblems() {
        return this.problems;
    }

    @Override
    public Problem getNextProblem() {
        if (this.currentProblemNumber < this.getNumberOfProblems()) {
            return this.problems.get(this.currentProblemNumber++);
        } else {
            return null;
        }
    }
}