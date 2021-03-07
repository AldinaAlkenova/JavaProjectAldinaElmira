package com.company;
//Imported libraries
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

   public void start() {//Main Menu
        while (true) {
            System.out.println("Choose one option (1-4):");
            System.out.println("1. Add new employee;");
            System.out.println("2. Get all employees;");
            System.out.println("3. Get employee by id;");
            System.out.println("4. Get employee's payment by id;");
            System.out.println("5. Update information by id;");
            System.out.println("0. Exit.");

            int choice = scanner.nextInt();
            if (choice == 1) { //if choose 1, demonstrate addEmployeeMenu
                addEmployeeMenu();
                System.out.println("************");
            } else if (choice==2){ //if choose 2, demonstrate getAllEmployeeMenu
                getAllEmployeeMenu();
                System.out.println("************");

            } else if (choice==3){ //if choose 3, demonstrate getEmployeeByIDMenu
                getEmployeeByIDMenu();
                System.out.println("************");
            }
            else if (choice==0) { //if choose 0, output message "Have a nice day!"
                System.out.println("Have a nice day!\n************");
                return;
            } else if (choice==4) { //if choose 4, demonstrate calculatePaymentMenu
                calculatePaymentMenu();
                System.out.println("************");
            } else if (choice==5) { //if choose 5, demonstrate updateEmployeeByIDMenu
                updateEmployeeByIDMenu();
                System.out.println("************");
            }
            else {
                System.out.println("You have to enter one number from the list"); //in another case returns message "You have to enter one number from the list"
                System.out.println("************");
                start();
            }
        }
    }
    public void addEmployeeMenu(){ //method for addEmployeeMenu
        System.out.println("What type of employee do you want to add: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){//for adding employee for full time
            addFullTimeEmployeeMenu();
        }
        else if (choice2==2){ //for adding employee for part time
            addPartTimeEmployeeMenu();
        }
    }

    public void getAllEmployeeMenu(){ //method for getAllEmployeeMenu
        System.out.println("What type of employee do you want to get: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){ //for getting list of all employees for full time
            getAllFullTimeEmployeesMenu();
        }
        else if (choice2==2){ //for getting list of all employees for part time
            getAllPartTimeEmployeesMenu();
        }
    }
    
    public void getEmployeeByIDMenu(){ //method for getEmployeeByIDMenu
        System.out.println("What type of employee do you want to get: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){ //for getting employee for full time
            getFTEByIDMenu();
        }
        else if (choice2==2){ //for getting employee for part time
            getPTEByIDMenu();
        }
    }
    public void updateEmployeeByIDMenu(){ //method for updateEmployeeByIDMenu
        System.out.println("What type of employee do you want to update: 1)Full Time Employee; 2)Part Time Employee?");
        int choice2 = scanner.nextInt();
        if (choice2==1){ //for updating employee for full time
            updateFTEByIDMenu();
        }
        else if (choice2==2){ //for updating employee for part time
            updatePTEByIDMenu();
        }
    }
    private void updateFTEByIDMenu(){ //method for updateFTEByIDMenu
        System.out.println("Type the ID of full time employee:"); //user must enter id
        int employeeid = scanner.nextInt();
        System.out.println("Enter the name of the full time employee:");//user must enter name
        String addName = scanner.next();
        System.out.println("Enter the surname of the full time employee:");//user must enter surname
        String addSurname = scanner.next();
        System.out.println("Enter the age of the full time employee:");//user must enter age
        int addAge = scanner.nextInt();
        System.out.println("Enter the position of the full time employee:");//user must enter position
        String addPosition = scanner.next();
        System.out.println("Enter the salary by the full time employee:");//user must enter salary
        Double addSalary = scanner.nextDouble();
        System.out.println(fteController.updateFTEByID(employeeid, addName, addSurname, addAge, addPosition, addSalary));
    }
    
    private void updatePTEByIDMenu(){//method for updatePTEByIDMenu
        System.out.println("Type the ID of part time employee:");//user must enter id
        int id = scanner2.nextInt();
        System.out.println("Enter the name of the part time employee:");//user must enter name
        String addName = scanner2.next();
        System.out.println("Enter the surname of the part time employee:");//user must enter surname
        String addSurname = scanner2.next();
        System.out.println("Enter the age of the part time employee:");//user must enter age
        int addAge = scanner2.nextInt();
        System.out.println("Enter the position of the part time employee:");//user must enter position
        String addPosition = scanner2.next();
        System.out.println("Enter the hours worked by the part time employee:");//user must enter hours worked
        Double addHoursWorked = scanner2.nextDouble();
        System.out.println("Enter the rate of the part time employee:");//user must enter rate
        Double addRate = scanner2.nextDouble();
        System.out.println(pteController.updatePTEByID(id, addName, addSurname, addAge, addPosition, addHoursWorked, addRate));
    }

    public void addFullTimeEmployeeMenu(){ //method for addFullTimeEmployeeMenu
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


    public void addPartTimeEmployeeMenu(){ //method for  addPartTimeEmployeeMenu
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

    private void getAllFullTimeEmployeesMenu(){ //method for getAllFullTimeEmployeesMenu
        List<FullTimeEmployee> fulltimeemployees = fteController.getAllFullTimeEmployees();
        for (FullTimeEmployee fulltimeemployee : fulltimeemployees) {
            System.out.println(fulltimeemployee.toString());
        }
    }

    private void getAllPartTimeEmployeesMenu(){ //method for getAllPartTimeEmployeesMenu
        List<PartTimeEmployee> parttimeemployees = pteController.getAllPartTimeEmployees();
        for (PartTimeEmployee parttimeemployee : parttimeemployees) {
            System.out.println(parttimeemployee.toString());
        }
    }
     private void getFTEByIDMenu(){ //method for getFTEByIDMenu
        System.out.println("Write the ID of full time employee");
        int id = scanner.nextInt();
        System.out.println(fteController.getFTEByID(id));
    }

    private void getPTEByIDMenu(){//method for getPTEByIDMenu
        System.out.println("Write the ID of part time employee");
        int id = scanner.nextInt();
        System.out.println(pteController.getPTEByID(id));
    }
    public void calculatePaymentMenu(){ //method for calculatePaymentMenu
        System.out.println("Choose the type of employee: 1) Full Time Employee; 2) Part Time Employee.");
        int choice=scanner.nextInt();
        if (choice==1){
            getPaymentFTEByIDMenu();
        }
        else if (choice==2){
            getPaymentPTEByIDMenu();
        }
        }
    private void getPaymentPTEByIDMenu(){//method for getPaymentPTEByIDMenu
        System.out.println("Write the ID of part time employee");
        int id = scanner.nextInt();
        System.out.println(pteController.getPaymentPTEByID(id));
    }
    private void getPaymentFTEByIDMenu(){ //method for getPaymentFTEByIDMenu
        System.out.println("Write the ID of full time employee");
        int id = scanner2.nextInt();
        System.out.println(fteController.getPaymentFTEByID(id));
    }
    
}
