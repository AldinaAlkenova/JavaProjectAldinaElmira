package com.company.Controllers;

import com.company.Entities.Employee;
import com.company.Entities.FullTimeEmployee;
import com.company.Repository.FTERepository;
import com.company.Repository.Interfaces.IFTERepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class FTEController {
    private final IFTERepository fteRepository;

    public FTEController(IFTERepository fteRepository) {
        this.fteRepository = fteRepository;
    }
   public String addFullTimeEmployee (int employeeID, String name, String surname, int age, String position, double salary){
        LocalDate dateOfAgreement=LocalDate.now();
        LocalDate expireDate= LocalDate.now().plusYears(1);
        FullTimeEmployee addFullTimeEmployee=new FullTimeEmployee(employeeID, name, surname, age, position, dateOfAgreement, expireDate, salary);
        boolean isAdded= fteRepository.addFullTimeEmployee(addFullTimeEmployee);
        if (isAdded=true){
            return "Completed!";
        }
        else return "Failed";
    }
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        List<FullTimeEmployee> fulltimeemployees = fteRepository.getAllFullTimeEmployees();
        return fulltimeemployees;
    }
}
