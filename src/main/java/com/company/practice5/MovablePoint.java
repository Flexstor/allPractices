package com.company.practice5;

public class MovablePoint implements Movable {
    protected double x;
    protected double y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void moveUp ( double y){
        this.y += y;
    }

    public void moveDown ( double y){
        this.y -= y;
    }

    public void moveLeft ( double x){
        this.x -= x;
    }


    public void moveRight ( double x){
        this.x += x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
