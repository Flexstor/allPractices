package com.company.practice5;

        import com.company.practice4.Rectangle;

public class MovableRectangle extends Rectangle implements Movable{
    private MovablePoint LeftUp;
    private MovablePoint RightDown;

    public MovableRectangle(MovablePoint LeftUp, MovablePoint RightDown){
        this.LeftUp = LeftUp;
        this.RightDown = RightDown;
    }

    public MovablePoint getLeftUp() {
        return LeftUp;
    }

    public MovablePoint getRightDown() {
        return RightDown;
    }

    public double getLength() {
        return Math.abs(LeftUp.getX() - RightDown.getX());
    }

    public double getWidth() {
        return Math.abs(LeftUp.getY() - RightDown.getY());
    }


    @Override
    public void moveUp(double y) {
        LeftUp.moveUp(y);
        RightDown.moveUp(y);
    }

    @Override
    public void moveDown(double y) {
        LeftUp.moveDown(y);
        RightDown.moveDown(y);
    }

    @Override
    public void moveLeft(double x) {
        LeftUp.moveLeft(x);
        RightDown.moveLeft(x);
    }

    @Override
    public void moveRight(double x) {
        LeftUp.moveRight(x);
        RightDown.moveRight(x);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "LeftUp=" + LeftUp +
                ", RightDown=" + RightDown +
                '}';
    }
}

