package com.company.Repository.Interfaces;

import com.company.Entities.FullTimeEmployee;
import com.company.Entities.PartTimeEmployee;

import java.util.List;

public interface IPTERepository {
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee); //for adding employee for part time
    public List<PartTimeEmployee> getAllPartTimeEmployees(); //getting list of all part time employee
    public PartTimeEmployee getPTEByID(int id); //searching part time employee by ID
    public double getPaymentPTEByID(int id);//getting payment of part time employee by ID
}
