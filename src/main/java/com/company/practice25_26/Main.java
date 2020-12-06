package com.company.practice25_26;

public class Main {
    public static void main(String[] args) {
        MyHashMapClass<Integer, String> hashMapClass = new MyHashMapClass<>();
        hashMapClass.add(1, "lesson1");
        hashMapClass.add(2, "lesson2");
        hashMapClass.add(1, "domZad");
        hashMapClass.add(3, "lesson3");

        System.out.println(hashMapClass.get(2));
        System.out.println(hashMapClass.get(1) + "\n//////////");

        hashMapClass.remove(2);

        for (String str : hashMapClass)
        {
            System.out.println(str);
        }
    }
}
