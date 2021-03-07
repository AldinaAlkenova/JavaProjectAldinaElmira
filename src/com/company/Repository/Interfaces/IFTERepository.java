package com.company.Repository.Interfaces;

import com.company.Entities.Employee;
import com.company.Entities.FullTimeEmployee;

import java.util.List;

public interface IFTERepository {
    public boolean addFullTimeEmployee(FullTimeEmployee fullTimeEmployee);//for adding new employee for full time
    public List<FullTimeEmployee> getAllFullTimeEmployees();//for getting list of all full time employees 
    public String getFTEByID(int id);//searching full time employee by ID
    public double getPaymentFTEByID(int id);//getting payment of full time employee by ID
}
