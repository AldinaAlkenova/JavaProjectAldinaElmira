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
// Method for adding new Full Time employees
    public String addFullTimeEmployee (int employeeID, String name, String surname, int age,
                                       String position, Double salary){
        LocalDate dateOfAgreement=LocalDate.now(); //setting current date as the Date of Agreement
        LocalDate expireDate= LocalDate.now().plusYears(1); //setting expiration date as a year after the Date of Agreement
        FullTimeEmployee addFullTimeEmployee=new FullTimeEmployee(employeeID, name, surname, age, position,
                dateOfAgreement, expireDate, salary);//adding new object of class Full Time Employee
        boolean isAdded= fteRepository.addFullTimeEmployee(addFullTimeEmployee); //assigning the result of the method of repository to boolean variable
        if (isAdded=true){
            return "Completed!";
        }
        else return "Failed";
    }
//Method for printing all the Full Time Employees
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        List<FullTimeEmployee> fulltimeemployees = fteRepository.getAllFullTimeEmployees();//creating a list of type FullTimeEmployee and assigning the result of the repository to it
        return fulltimeemployees;
    }
//Method for finding Full Time Employee by ID
    public String getFTEByID(int id){
        String result=fteRepository.getFTEByID(id);
        return result;
    }
    //Method for finding the payment per year of the Full Time Employee by ID
    public String getPaymentFTEByID(int id){
        Double result=fteRepository.getPaymentFTEByID(id);
        if (result>0) {
            return result.toString();
        }
        else {
            return "The Employee ID was not found among Full Time Employees. Please, make sure you have entered correct information.";
        }
    }
    //Method for updating information of the Full Time Employee by ID
    public String updateFTEByID(int id, String name, String surname, int age, String position, Double salary){
        Boolean isUpdated=fteRepository.updateFTEByID(id, name, surname, age, position, salary);
        if (isUpdated=true){
            return "Completed!";
        }
        else return "Failed, try again!";
    }
}
