package com.bumb.speedmath;

/**
 * Created by manisharora on 8/11/13.
 */
public class RandomNumberGenerator {
    public static int randomIntGenerator(int minVal, int maxVal) {
        int x = minVal + (int)(Math.random() * (maxVal - minVal));
        //System.out.println("Min: " + minVal + " Max: " + maxVal + " Random: " + x);
        return x;
    }

    public static double randomDoubleGenerator(double minVal, double maxVal) {
        return minVal + (Math.random() * (maxVal - minVal));
    }
}
