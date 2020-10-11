package com.company.practice9;

public class SalarySelector implements EmployeeSelector{

    private int salaryStart;
    private int salaryEnd;

    public SalarySelector(int salaryStart, int salaryEnd) {
        this.salaryStart = salaryStart;
        this.salaryEnd = salaryEnd;
    }

    @Override
    public boolean isNeedEmployee(Employee employee) {
        return employee.getSalary() >= salaryStart && employee.getSalary() <= salaryEnd;
    }
}
