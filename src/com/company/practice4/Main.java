package com.company.practice4;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7, "green", true);
        Rectangle rectangle = new Rectangle(3, 7, "yellow", true);
        Square square = new Square(2,  "black", false);
        System.out.println(circle.toString() + ", area = " + circle.getArea() + ", perimeter = " + circle.getPerimeter());
        System.out.println(rectangle.toString() + ", area = " + rectangle.getArea() + ", perimeter = " + rectangle.getPerimeter());
        System.out.println(square.toString() + ", area = " + square.getArea() + ", perimeter = " + square.getPerimeter());
    }
}
