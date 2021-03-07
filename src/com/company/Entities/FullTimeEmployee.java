package com.company.Entities;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee{
    public FullTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
    }

    @Override
    public double calculateSalary() {
        LocalDate expiredate=getExpireDate();
        LocalDate dateofagreement=getDateOfAgreement();
        return 0;
    }

    public FullTimeEmployee(){};


    @Override
    public String toString()
    {
        return "Full time employee ID: " + super.getEmployeeID()+ "; name: " + super.getName() + "; surname: " + super.getSurname() + "; age: " + super.getAge() + "; position: " + getPosition();
    }
}
