package com.company.practice78;

public class TopManager implements EmployeePosition{

    private Company company;

    public TopManager(Company company)
    {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome() > 10000000)
            return 2.5 * baseSalary;
        else
            return baseSalary;
    }
}
