package com.company.practice3;

public class Circle {
    private int radius;
    private double area;

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        area = 3.14 * (radius * radius);
        return area;
    }
}
