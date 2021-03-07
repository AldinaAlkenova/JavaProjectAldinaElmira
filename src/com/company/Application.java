package com.company;

import com.company.Entities.FullTimeEmployee;
import com.company.Entities.PartTimeEmployee;
import com.company.Controllers.FTEController;
import com.company.Controllers.PTEController;

import java.util.List;
import java.util.Scanner;

public class Application {
    private final FTEController fteController;
    private final PTEController pteController;
    private final Scanner scanner;
    private final Scanner scanner2;

    public Application (FTEController fteController, PTEController pteConroller){
        this.fteController=fteController;
        this.pteController=pteConroller;
        scanner=new Scanner(System.in);
        scanner2 = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Choose one option (1-4):");
            System.out.println("1. Add new employee;");
            System.out.println("2. Get all employees;");
            System.out.println("3. Get employee by id");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            if (choice == 1) {
                addEmployeeMenu();
                System.out.println("************");
            } else if (choice==2){
                getAllEmployeeMenu();
                System.out.println("************");
                
            } else if (choice==3){
                getEmployeeByIDMenu();
                System.out.println("************");
            }
            else if (choice==0) {
                System.out.println("Have a nice day!\n************");
                return;
            }
            else {
                System.out.println("You have to enter one number from the list");
                System.out.println("************");
                start();
            }
        }
    }
    public void addEmployeeMenu(){
        System.out.println("What type of employee do you want to add: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){
            addFullTimeEmployeeMenu();
        }
        else if (choice2==2){
            addPartTimeEmployeeMenu();
        }
    }

    public void getAllEmployeeMenu(){
        System.out.println("What type of employee do you want to get: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){
            getAllFullTimeEmployeesMenu();
        }
        else if (choice2==2){
            getAllPartTimeEmployeesMenu();
        }
    }
    
    public void getEmployeeByIDMenu(){
        System.out.println("What type of employee do you want to get: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){
            getFTEByIDMenu();
        }
        else if (choice2==2){
            getPTEByIDMenu();
        }
    }

    public void addFullTimeEmployeeMenu(){
        System.out.println("Enter the ID of the full time employee that you want to add:");
        int addID = scanner.nextInt();
        System.out.println("Enter the name of the full time employee that you want to add:");
        String addName = scanner.next();
        System.out.println("Enter the surname of the full time employee that you want to add:");
        String addSurname = scanner.next();
        System.out.println("Enter the age of the full time employee that you want to add:");
        int addAge = scanner.nextInt();
        System.out.println("Enter the position of the full time employee that you want to add:");
        String addPosition = scanner.next();
        System.out.println("Enter the salary of the full time employee that you want to add:");
        Double addSalary = scanner.nextDouble();
        String result = fteController.addFullTimeEmployee(addID, addName, addSurname, addAge, addPosition, addSalary);
        System.out.println(result);
    }


    public void addPartTimeEmployeeMenu(){
        System.out.println("Enter the ID of the part time employee that you want to add:");
        int addID = scanner2.nextInt();
        System.out.println("Enter the name of the part time employee that you want to add:");
        String addName = scanner2.next();
        System.out.println("Enter the surname of the part time employee that you want to add:");
        String addSurname = scanner2.next();
        System.out.println("Enter the age of the part time employee that you want to add:");
        int addAge = scanner2.nextInt();
        System.out.println("Enter the position of the part time employee that you want to add:");
        String addPosition = scanner2.next();
        System.out.println("Enter the hours worked by the part time employee that you want to add:");
        Double addHoursWorked = scanner2.nextDouble();
        System.out.println("Enter the rate of the part time employee that you want to add:");
        Double addRate = scanner2.nextDouble();
        String result = pteController.addPartTimeEmployee(addID, addName, addSurname, addAge, addPosition, addHoursWorked, addRate);
        System.out.println(result);
    }

    private void getAllFullTimeEmployeesMenu(){
        List<FullTimeEmployee> fulltimeemployees = fteController.getAllFullTimeEmployees();
        for (FullTimeEmployee fulltimeemployee : fulltimeemployees) {
            System.out.println(fulltimeemployee.toString());
        }
    }

    private void getAllPartTimeEmployeesMenu(){
        List<PartTimeEmployee> parttimeemployees = pteController.getAllPartTimeEmployees();
        for (PartTimeEmployee parttimeemployee : parttimeemployees) {
            System.out.println(parttimeemployee.toString());
        }
    }
     private void getFTEByIDMenu(){
        System.out.println("Write the ID of full time employee");
        int id = scanner.nextInt();
        System.out.println(fteController.getFTEByID(id));
    }

    private void getPTEByIDMenu(){
        System.out.println("Write the ID of part time employee");
        int id = scanner.nextInt();
        System.out.println(pteController.getPTEByID(id));
    }
}
