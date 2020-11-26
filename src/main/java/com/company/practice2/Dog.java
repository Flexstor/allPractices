package com.company.practice2;

public class Dog {
    private int age;
    private String name;

    public Dog() {
        age = 0;
        name = "";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int age_to_human() {
        return (age * 7);
    }

    @Override
    public String toString() {
        return ("Возраст - " + age +
                "\tКличка - " + name);
    }
}
