package com.bumb.speedmath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manisharora on 8/11/13.
 */
public class Stage {
    private int numberOfProblems;
    private Map<ProblemTypeEnum, Integer> problemTypeProbability;

    public Stage(int numberOfProblems) {
        this.numberOfProblems = numberOfProblems;
        problemTypeProbability = new HashMap<ProblemTypeEnum, Integer>();
    }

    public void addProblemType(ProblemTypeEnum problemType, int percent) {
        problemTypeProbability.put(problemType, percent);
    }

    public ArrayList<Problem> getProblems() {
        int cumulativeProbability = 0;
        for (ProblemTypeEnum problemType : problemTypeProbability.keySet()) {
            cumulativeProbability += problemTypeProbability.get(problemType);
            problemTypeProbability.put(problemType, cumulativeProbability);
        }

        ArrayList<Problem> problems = new ArrayList<Problem>();
        for (int i=0; i < this.numberOfProblems; i++) {
            int random = RandomNumberGenerator.randomIntGenerator(1, 101);
            for (ProblemTypeEnum problemType : problemTypeProbability.keySet()) {
                if (random <= problemTypeProbability.get(problemType)) {
                    problems.add(ProblemGenerator.getQuestion(problemType));
                    break;
                }
            }
        }
        return problems;
    }
}