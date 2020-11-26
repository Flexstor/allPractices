package com.company.practice9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();

        for (int i = 0; i < 15; i++){
            company.hire(new Employee(
                    "Employee",
                    "" + Integer.toString(i+1),
                    LocalDate.of(1955 + random.nextInt(49), random.nextInt(11) + 1, random.nextInt(28) + 1),
                    "Moscow",
                    "8900-900-20-22",
                    (int)(1000 + Math.random() * 99_000)));
        }

        System.out.println("Сотрудники, зарплата которых колеблется от 10000 до 20000:");
        company.doSomethingWithEmployees(
                new SalarySelector(10_000, 20_000),
                (employee, index) -> System.out.println(employee));

        System.out.println("Повышаем зарплату сотрудникам на 3000, зарплата которых меньше 5000: ");
        int a = 3_000;
        company.printList();
        company.doSomethingWithEmployees(new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return employee.getSalary() < a;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployee(Employee employee, int index) {
                employee.setSalary(employee.getSalary() + 5000);
                System.out.println(employee);
            }
        });
    }
}
