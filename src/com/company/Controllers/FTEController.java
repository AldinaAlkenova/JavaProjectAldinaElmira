package com.company.controllers;

import com.company.Entities.FullTimeEmployee;
import com.company.repositories.interfaces.IFTERepository;

import java.time.LocalDate;
import java.util.List;

public class FTEController {
    private final IFTERepository fteRepository;

    public FTEController(IFTERepository fteRepository) {
        this.fteRepository = fteRepository;
    }

    public String addFullTimeEmployee (int employeeID, String name, String surname, int age,
                                       String position, double salary){
        LocalDate dateOfAgreement=LocalDate.now();
        LocalDate expireDate= LocalDate.now().plusYears(1);
        FullTimeEmployee addFullTimeEmployee=new FullTimeEmployee(employeeID, name, surname, age, position,
                dateOfAgreement, expireDate, salary);
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

    public String getFTEByID(int id){
        String result=fteRepository.getFTEByID(id).toString();
        return result;
    }
    public String getPaymentFTEByID(int id){
        Double result=fteRepository.getPaymentFTEByID(id);
        if (result>0) {
            return result.toString();
        }
        else {
            return "The Employee ID was not found among Full Time Employees. Please, make sure you have entered correct information.";
        }}
}
