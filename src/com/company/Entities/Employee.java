package com.company.Entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public abstract class Employee { //Abstract class Employee that has fields such as employeeID, age, name, surname, position, dateOfAgreement amd expireDate
    private static int employeeID;
    private static int age;
    private static String name;
    private static String surname;
    private static String position;
    private static LocalDate dateOfAgreement;
    private static LocalDate expireDate;

    public Employee(){}; //default constructor
    public Employee(int employeeID, String name, String surname, int age, String position, LocalDate dateOfAgreement, LocalDate expireDate ) {//parametrized constructor
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.dateOfAgreement=dateOfAgreement;
        this.expireDate=expireDate;
    }
    public abstract double calculatePayment (); //abstract method "calculatePayment" that will calculate total salary
    public static int getAge() { //getter for "age"
        return age;
    }

    public static Integer getEmployeeID() { //getter for "EmployeeID"
        return employeeID;
    }

    public static String getName() { //getter for "name"
        return name;
    }

    public static String getPosition() { //getter for "position"
        return position;
    }

    public static String getSurname() { //getter for "surname"
        return surname;
    }

    public static LocalDate getExpireDate() { //getter for "expireDate"
        return expireDate;
    }

    public static LocalDate getDateOfAgreement() { //getter for "DateOfAgreement"
        return dateOfAgreement;
    }

    public void setAge(Integer age) { //setter for "age"
        this.age = age;
    }

    public void setEmployeeID(Integer employeeID) { //setter for "employeeID"
        this.employeeID = employeeID;
    }

    public void setName(String name) { //setter for name
        this.name = name;
    }

    public void setDateOfAgreement(LocalDate dateOfAgreement) { //setter for "DateOfAgreement"
        this.dateOfAgreement = dateOfAgreement;
    }

    public void setSurname(String surname) { //setter for "surname"
        this.surname = surname;
    }

    public void setPosition(String position) { //setter for "position"
        this.position = position;
    }

    public void setExpireDate(LocalDate expireDate) { //setter for "expireDate"
        this.expireDate = expireDate;
    }
}
