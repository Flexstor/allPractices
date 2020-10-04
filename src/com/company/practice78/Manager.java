package com.company.practice78;

public class Manager implements EmployeePosition {
    private double count = 115000 + (Math.random() * 25000);

    public double getCount() {
        return count;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + 0.05 * count;
    }
}
