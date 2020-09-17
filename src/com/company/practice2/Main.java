package com.company.practice2;

public class Main {
    public static void main(String[] args) {
        //1
        Shape triangle = new Shape();
        triangle.setLength(10);
        triangle.setWidth(20);
        System.out.println("Фигура:\n" +
                triangle.getLength() +
                "\n" + triangle.getWidth() +
                "\n" + triangle.toString());

        //2
        Ball football = new Ball();
        football.setRadius(5);
        football.setVolume(15);
        System.out.println("Мяч:\n" +
                football.getRadius() +
                "\n" + football.getVolume() +
                "\n" + football.toString());

        //3
        Book tutorial = new Book();
        tutorial.setPages(75);
        tutorial.setPrice(150);
        System.out.println("Книга:\n" +
                tutorial.getPages() +
                "\n" + tutorial.getPrice() +
                "\n" + tutorial.toString());

        //4
        Dog a = new Dog();
        a.setAge(4);
        a.setName("Ponchik");
        System.out.println(a.toString());
        System.out.println(a.age_to_human());
        Dog_nursery b = new Dog_nursery();
        b.add(a);

    }
}
