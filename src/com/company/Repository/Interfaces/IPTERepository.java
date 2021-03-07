package com.company.Repository.Interfaces;

import com.company.Entities.FullTimeEmployee;
import com.company.Entities.PartTimeEmployee;

import java.util.List;

public interface IPTERepository {
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee);
    public List<PartTimeEmployee> getAllPartTimeEmployees();
    public PartTimeEmployee getPTEByID(int id);
    public double getPaymentPTEByID(int id);
}
