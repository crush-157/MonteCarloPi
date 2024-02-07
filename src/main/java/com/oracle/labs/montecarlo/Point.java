package com.oracle.labs.montecarlo;

import java.util.Random;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point getNewPoint() {
        return new Point(getRandomAxisValue(), getRandomAxisValue());
    }

    private static double getRandomAxisValue() {
        return new Random().nextDouble() * 2 - 1;
    }

    public Boolean insideCircle() {
        return (Math.pow(getX(), 2.0) + Math.pow(getY(), 2.0) <= 1);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": (" + x + ", " + y + ")";
    }
}
