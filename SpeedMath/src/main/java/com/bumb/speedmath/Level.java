package com.bumb.speedmath;

import java.util.ArrayList;

/**
 * Created by manisharora on 8/11/13.
 */

public abstract class Level {
    public abstract ArrayList<Problem> getProblems();
    public abstract int getNumberOfStages();
    public abstract int getNumberOfProblems();
    public abstract Problem getNextProblem();
}
