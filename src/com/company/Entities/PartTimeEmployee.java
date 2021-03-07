package com.company.Entities;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee{
    private static Double hoursWorked;
    private static Double rate;

    public PartTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate, Double hoursWorked, Double rate) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }
    public PartTimeEmployee(){}

    @Override
    public double calculateSalary() {
        return hoursWorked*rate;
    }

    ;

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public static double getHoursWorked() {
        return hoursWorked;
    }

    public static double getRate() {
        return rate;
    }

    @Override
    public String toString()
    {
        return "Freelancer employee ID: " + super.getEmployeeID() + " name: " + super.getName() + " surname: " + super.getSurname() + " age: " + super.getAge() +  " position: " + getPosition();
    }
}