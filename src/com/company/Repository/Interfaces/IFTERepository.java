package com.company.Repository.Interfaces;

import com.company.Entities.Employee;
import com.company.Entities.FullTimeEmployee;

import java.util.List;

public interface IFTERepository {
    public boolean addFullTimeEmployee(FullTimeEmployee fullTimeEmployee);
    public List<FullTimeEmployee> getAllFullTimeEmployees();
}
