package com.company.practice9;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void fire(int index){
        employees.remove(index);
    }

    public void doSomethingWithEmployees(EmployeeSelector selector, EmployeeHandler handler){
        int count = 0;
        for(Employee employee : employees){
            if (selector.isNeedEmployee(employee)){
                handler.handleEmployee(employee, count);
                count++;
            }
        }
        System.out.println(count);
        System.out.println("*******************************************************\n");
    }

    public void printList(){
        for (Employee employee:
             employees) {
            System.out.println(employee);
        }
        System.out.println("*******************************************************");
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}
