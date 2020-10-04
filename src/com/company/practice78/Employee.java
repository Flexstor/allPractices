package com.company.practice78;

public class Employee {
    private String surname;
    private String name;
    private double fixSalary;
    private double salary;
    private EmployeePosition Position;

    public Employee(String surname, String name, double fixSalary, EmployeePosition position) {
        this.surname = surname;
        this.name = name;
        this.fixSalary = fixSalary;
        Position = position;
        this.salary = Position.calcSalary(fixSalary);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFixSalary(double fixSalary) { this.fixSalary = fixSalary; }

    public double getFixSalary() { return fixSalary; }

    public void setPosition(EmployeePosition position) {
        Position = position;
    }

    public EmployeePosition getPosition() {
        return Position;
    }

    public double getSalary() { return salary; }
}
