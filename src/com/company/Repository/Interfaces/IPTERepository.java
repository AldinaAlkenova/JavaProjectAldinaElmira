package com.company.Repository.Interfaces;

import com.company.Entities.FullTimeEmployee;
import com.company.Entities.PartTimeEmployee;

import java.util.List;

public interface IPTERepository {
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee); //for adding employee for part time
    public List<PartTimeEmployee> getAllPartTimeEmployees(); //getting list of all part time employee
    public String getPTEByID(int id);
    public double getPaymentPTEByID(int id);
    public boolean updatePTEByID(int id, String name, String surname, int age, String position, double hoursWorked, double rate);
}
