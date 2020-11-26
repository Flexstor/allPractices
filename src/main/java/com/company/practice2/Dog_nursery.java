package com.company.practice2;

public class Dog_nursery {
    int place = 0;
    Dog[] arr = new Dog[10];

    public void add(Dog dog) {
        arr[place] = dog;
        place++;
        System.out.println("Succes!");
    }
}
