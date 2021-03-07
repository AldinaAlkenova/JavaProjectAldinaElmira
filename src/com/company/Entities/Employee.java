package com.company.Entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public abstract class Employee {
    private static int employeeID;
    private static int age;
    private static String name;
    private static String surname;
    private static String position;
    private static LocalDate dateOfAgreement;
    private static LocalDate expireDate;

    public Employee(){};
    public Employee(int employeeID, String name, String surname, int age, String position, LocalDate dateOfAgreement, LocalDate expireDate ) {
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.dateOfAgreement=dateOfAgreement;
        this.expireDate=expireDate;
    }
    public abstract double calculateSalary ();
    public static int getAge() {
        return age;
    }

    public static Integer getEmployeeID() {
        return employeeID;
    }

    public static String getName() {
        return name;
    }

    public static String getPosition() {
        return position;
    }

    public static String getSurname() {
        return surname;
    }

    public static LocalDate getExpireDate() {
        return expireDate;
    }

    public static LocalDate getDateOfAgreement() {
        return dateOfAgreement;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfAgreement(LocalDate dateOfAgreement) {
        this.dateOfAgreement = dateOfAgreement;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
