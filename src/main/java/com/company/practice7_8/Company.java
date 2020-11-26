package com.company.practice7_8;

import  java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Company {
    private List <Employee> employees = new ArrayList<>();

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        for(Employee employee: employeeList){
            hire(employee);
        }
    }

    public Employee searchForFire(String name, String surname, String position){

        for(Employee employee: employees){
            if(employee.getName().equals(name) && employee.getSurname().equals(surname) && employee.getPosition().getJobTitle() == position){
                return employee;
            }
        }
        return null;
    }

    public void fire(String surname, String name, String position){
        employees.remove(searchForFire(name, surname, position));
    }

    public void fire(int indexOfEmployee){
        employees.remove(indexOfEmployee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getIncome(){
        double income = 0;
        for (Employee employee: employees) {
            if(employee.getPosition().getJobTitle().equals("Manager")) {
                income += ((Manager)employee.getPosition()).getCount();
            }
        }
        return income;
    }

    public void sortEmployeesTop(){
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
    }

    public void sortEmployeesLowest(){
        employees.sort(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> getTopSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesTop();
            return employees.subList(0, count);
        }
        else
            return null;

    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count > 0 && employees.size() > count){

            this.sortEmployeesLowest();
            return employees.subList(0, count);
        }
        else
            return null;
    }

    public void PrintList(){
        for(Employee employee: employees){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }

    public void PrintList(List<Employee> list){
        for(Employee employee: list){
            System.out.println(employee.getSurname() + " " + employee.getName() + " - " + employee.getPosition().getJobTitle() + " " +
                    (int)employee.getPosition().calcSalary(employee.getFixSalary()) + " рублей");
        }
    }
}
