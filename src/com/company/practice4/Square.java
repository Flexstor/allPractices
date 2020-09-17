package com.company.practice4;

public class Square extends Shape{
    protected double side;

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(){}

    @Override
    public double getArea() {return (side*side);}
    @Override
    public double getPerimeter() {return (side*4);}


    public void setSide(double side) {this.side = side;}
    public double getSide() {return side;}

    @Override
    public String toString() {
        return ("Square:\n" +
                "side = " + side +
                ", color = '" + color + '\'' +
                ", filled = " + filled);
    }
}