package com.company.Entities;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee{
    private static double salary;
    public FullTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate, double salary) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
        this.salary=salary;
    }

    @Override
    public double calculatePayment() {
        return 12*salary;
    }

    public FullTimeEmployee(){};

    public static Double getSalary() {
        return salary;
    }

    public static void setSalary(Double salary) {
        FullTimeEmployee.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Full time employee ID: " + super.getEmployeeID()+ "; name: " + super.getName() + "; surname: " + super.getSurname() + "; age: " + super.getAge() + "; position: " + getPosition() + "; salary: " + getSalary();
    }
}
