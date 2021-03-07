package com.company.Entities;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee{//class "FullTimeEmployee" that extends from abstract class "Employee"
    private static Double salary; //field salary with data type double
    public FullTimeEmployee(int employeeID, String name, String surname, int age, String position, LocalDate dateofagreement, LocalDate expiredate, Double salary) {
        super(employeeID, name, surname, age, position, dateofagreement, expiredate);
        this.salary=salary;
    }

    @Override
    public Double calculatePayment() { //method "calculatePayment" that returns total salary in the year
        return 12*salary;
    }

    public FullTimeEmployee(){};

    public static Double getSalary() { //getter for "salary"
        return salary;
    }

    public static void setSalary(Double salary) { //setter for "salary"
        FullTimeEmployee.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Full time employee ID: " + super.getEmployeeID()+ "; name: " + super.getName() + "; surname: " + super.getSurname() + "; age: " + super.getAge() + "; position: " + getPosition() + "; salary: " + getSalary();
    }
}
