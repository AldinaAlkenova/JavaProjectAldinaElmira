package com.company.Entities;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee{
    private double salary;
    public FullTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate, double salary) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
        this.salary=salary;
    }

    @Override
    public double calculatePayment() {
        return salary*12;
    }

    public FullTimeEmployee(){};


    @Override
    public String toString()
    {
        return "Full time employee ID: " + super.getEmployeeID()+ "; name: " + super.getName() + "; surname: " + super.getSurname() + "; age: " + super.getAge() + "; position: " + getPosition();
    }
}
