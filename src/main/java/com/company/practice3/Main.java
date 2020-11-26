package com.company.practice3;

public class Main {

    public static void main(String[] args)
    {
        Human.Head head = new Human.Head("карие", "черные");
        Human.Leg legLeft = new Human.Leg(80, 15);
        Human.Leg legRight = new Human.Leg(79, 15);
        Human.Hand handLeft = new Human.Hand(60, 10);
        Human.Hand handRight = new Human.Hand(60, 10);

        Human a = new Human(head, legLeft, legRight, handLeft, handRight);
        System.out.println(a.toString());
    }
}
