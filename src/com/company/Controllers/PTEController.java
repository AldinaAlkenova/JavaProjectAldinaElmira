package com.company.controllers;

import com.company.Entities.PartTimeEmployee;
import com.company.repositories.interfaces.IPTERepository;

import java.time.LocalDate;
import java.util.List;

public class PTEController {
    private final IPTERepository pteRepository;
    public PTEController(IPTERepository pteRepository) {
        this.pteRepository = pteRepository;
    }
    public String addPartTimeEmployee (int employeeID, String name, String surname, int age, String position, double hoursWorked, double rate){
        LocalDate dateOfAgreement=LocalDate.now();
        LocalDate expireDate= LocalDate.now().plusYears(1);
        PartTimeEmployee addPartTimeEmployee=new PartTimeEmployee(employeeID, name, surname, age, position, dateOfAgreement, expireDate, hoursWorked, rate);
        boolean isAdded= pteRepository.addPartTimeEmployee(addPartTimeEmployee);
        if (isAdded=true){
            return "Completed!";
        }
        else return "Failed";
    }

    public List<PartTimeEmployee> getAllPartTimeEmployees() {
        List<PartTimeEmployee> parttimeemployee = pteRepository.getAllPartTimeEmployees();
        return parttimeemployee;
    }

    public String getPTEByID(int id){
        String result=pteRepository.getPTEByID(id).toString();
        return result;
    }
}
