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
    public String addPartTimeEmployee (int employeeID, String name, String surname, int age, String position, Double hoursWorked, Double rate){
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
        String result=pteRepository.getPTEByID(id);
        return result;
    }
    public String getPaymentPTEByID(int id){
        Double result=pteRepository.getPaymentPTEByID(id);
        if (result>0){
        return result.toString();
    }
        else {
            return "The Employee ID was not found among Part Time Employees. Please, make sure you have entered correct information.";
        }}
    public String updatePTEByID(int id, String name, String surname, int age, String position, Double hoursWorked, Double rate){
        Boolean isUpdated=pteRepository.updatePTEByID(id, name, surname, age, position, hoursWorked, rate);
        if (isUpdated=true){
            return "Completed!";
        }
        else return "Failed, try again!";
    }
}
