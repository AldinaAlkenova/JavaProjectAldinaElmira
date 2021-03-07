package com.company.Entities;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee{ //class "PartTimeEmployee" that extends from abstract class Employee
    private static Double hoursWorked;
    private static Double rate;

    public PartTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate, Double hoursWorked, Double rate) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }
    public PartTimeEmployee(){}

    @Override
    public double calculatePayment() { //method "calculatePayment" that returns payment by the formula "hoursWorked*rate" 
        return hoursWorked*rate;
    }

    ;

    public void setHoursWorked(Double hoursWorked) { //setters for hoursWorked
        this.hoursWorked = hoursWorked;
    }

    public void setRate(Double rate) { //setters for rate
        this.rate = rate;
    }

    public static double getHoursWorked() { //getters for hoursWorked
        return hoursWorked;
    }

    public static double getRate() { //getters for rate
        return rate;
    }

    @Override
    public String toString()
    {
       return "Freelancer employee ID: " + super.getEmployeeID() + "; name: " + super.getName() + "; surname: " + super.getSurname() + "; age: " + super.getAge() +  "; position: " + getPosition() + "; hours worked: " + getHoursWorked() + "; rate: " + getRate();
    }
}
