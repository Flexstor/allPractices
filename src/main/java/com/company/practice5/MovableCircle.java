package com.company.practice5;

import com.company.practice4.Circle;

public class MovableCircle extends Circle implements Movable {
    private MovablePoint center;

    public MovableCircle(int radius, double x, double y) {
        center = new MovablePoint(x, y);
        this.radius = radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    public void setCenter(MovablePoint center) {
        this.center = center;
    }

    @Override
    public void moveUp(double y) {
        center.y += y;
    }

    @Override
    public void moveDown(double y) {
        center.y -= y;
    }

    @Override
    public void moveLeft(double x) {
        center.x -= x;
    }

    @Override
    public void moveRight(double x) {
        center.x += x;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
