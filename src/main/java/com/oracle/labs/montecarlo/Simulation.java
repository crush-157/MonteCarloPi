package com.oracle.labs.montecarlo;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Simulation {
    private final int points;

    public Simulation(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public double getValue() {
        Point[] pointArr = new Point[this.getPoints()];
        int insideCircle = 0;

        Arrays.setAll(pointArr, p -> Point.getNewPoint());
        for (Point point : pointArr) {
            if (point.insideCircle()) {
                insideCircle++;
            }
        }
        return 4.0 * insideCircle / this.getPoints();
    }

    public double percentDelta(double piValue) {
        return Math.pow(Math.pow(((100 * Math.PI / piValue) - 100), 2.0), 0.5);
    }

    public String getTask() {
        DecimalFormat df = new DecimalFormat("###,###,###,###,###");
        return "Task: calculate value of Pi using Monte Carlo method for " + df.format(this.getPoints()) + " points.";
    }
}
