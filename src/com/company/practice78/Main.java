package com.company.practice78;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 1; i <= 180 ; i++) {
            company.hire(new Employee("Operator ", Integer.toString(i),
                    2000 + (Math.random() * 5000), new Operator()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("Manager", Integer.toString(i),
                    7000 + (Math.random() * 10000), new Manager()));
        }

        for (int i = 1; i <= 80 ; i++) {
            company.hire(new Employee("TopManager", Integer.toString(i),
                    15000 + (Math.random() * 25000), new TopManager(company)));
        }

        company.getIncome();
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        for (int i = 0; i < company.getEmployees().size()/2; i++) {
            company.fire((int)Math.random() * 340);
        }

        System.out.println("\nПосле увольнения: \n");
        company.PrintList(company.getTopSalaryStaff(10));
        System.out.println("*************************************************");
        company.PrintList(company.getLowestSalaryStaff(30));

        System.out.println();
        Company company1 = new Company();
        company1.hire(new Employee("Shikalov", "Danila", 2000, new Manager()));
        company1.PrintList();
        company1.fire("Danila", "Shikalov", "Manager");
        company1.PrintList();
    }
}
