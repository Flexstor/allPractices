package com.company.practice5;

public class Main {
    public static void main(String[] args) {
        MovablePoint a = new MovablePoint(7, 10);
        System.out.println(a);
        a.moveLeft(12);
        a.moveRight(15);
        a.moveUp(4);
        a.moveDown(5);
        System.out.println(a);
        MovableCircle b = new MovableCircle(2, 10, 16);
        System.out.println(b);
        b.moveLeft(11);
        b.moveRight(0);
        b.moveUp(15);
        b.moveDown(20);
        System.out.println(b);
        MovableRectangle c = new MovableRectangle(new MovablePoint(12, 23),new MovablePoint(20,15));
        System.out.println(c);
        c.moveUp(20);
        c.moveRight(50);
        System.out.println(c.getLength());
        System.out.println(c);
    }
}

