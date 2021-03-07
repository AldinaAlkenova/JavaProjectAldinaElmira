package com.company.Repository;

import com.company.Data.Interfaces.IDB;
import com.company.Entities.Employee;
import com.company.Entities.FullTimeEmployee;
import com.company.Entities.PartTimeEmployee;
import com.company.Repository.Interfaces.IPTERepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class PTERepository implements IPTERepository {
    private final IDB postgreSQL;
    public PTERepository (IDB postgreSQL){
        this.postgreSQL=postgreSQL;
    }
    @Override
    public boolean addPartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        Connection connection = null;
        try{
            connection =postgreSQL.getConnection();
            /*
            for adding new employee for part time was used SQL code 
            INSERT INTO employee (employeeID, name, surname, age, position, dateofagreement, expiredate) VALUES (?, ?, ?, ?, ?, ?, ?); INSERT INTO parttimeemployee (employeeID, hoursworked, rate) VALUES (?, ?, ?);
            */
            String sql = "INSERT INTO employee (employeeID, name, surname, age, position, dateofagreement, expiredate) VALUES (?, ?, ?, ?, ?, ?, ?); INSERT INTO parttimeemployee (employeeID, hoursworked, rate) VALUES (?, ?, ?); ";
            PreparedStatement st = connection.prepareStatement (sql);
            st.setInt(1, PartTimeEmployee.getEmployeeID());
            st.setString(2, PartTimeEmployee.getName());
            st.setString(3, PartTimeEmployee.getSurname());
            st.setInt(4, PartTimeEmployee.getAge());
            st.setString(5, PartTimeEmployee.getPosition());
            st.setDate(6, Date.valueOf(PartTimeEmployee.getDateOfAgreement()));
            st.setDate(7, Date.valueOf(PartTimeEmployee.getExpireDate()));
            st.setInt(8, PartTimeEmployee.getEmployeeID());
            st.setDouble(9, PartTimeEmployee.getHoursWorked());
            st.setDouble(10, PartTimeEmployee.getRate());

            st.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<PartTimeEmployee> getAllPartTimeEmployees(){
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            /*
            for getting list all of part time employees was used SQL code 
            SELECT * FROM parttimeemployee INNER JOIN employee ON employee.employeeid=parttimeemployee.employeeid;
            */
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM parttimeemployee INNER JOIN employee ON employee.employeeid=parttimeemployee.employeeid;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PartTimeEmployee> parttimeemployee=new LinkedList<>();
            while (resultSet.next()){
                PartTimeEmployee partTimeEmployee=new PartTimeEmployee (resultSet.getInt("employeeid"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("position"),
                        resultSet.getDate("dateofagreement").toLocalDate(),
                        resultSet.getDate("expiredate").toLocalDate(),
                        resultSet.getDouble("hoursworked"),
                        resultSet.getDouble("rate"));
                parttimeemployee.add(partTimeEmployee);
            }
            return parttimeemployee;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //Connecting SQL Statement used to find the Part Time Employee by ID to the Classes
     @Override
    public String getPTEByID(int id){
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM parttimeemployee INNER JOIN employee on employee.employeeid=parttimeemployee.employeeid WHERE employee.employeeid=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            PartTimeEmployee partTimeEmployee=new PartTimeEmployee();

            if (resultSet.next()){
                partTimeEmployee.setEmployeeID(resultSet.getInt("employeeid"));
                partTimeEmployee.setName(resultSet.getString("name"));
                partTimeEmployee.setSurname(resultSet.getString("surname"));
                partTimeEmployee.setAge(resultSet.getInt("age"));
                partTimeEmployee.setPosition(resultSet.getString("position"));
                partTimeEmployee.setDateOfAgreement(resultSet.getDate("dateofagreement").toLocalDate());
                partTimeEmployee.setExpireDate(resultSet.getDate("expiredate").toLocalDate());
                partTimeEmployee.setHoursWorked(resultSet.getDouble("hoursworked"));
                partTimeEmployee.setRate(resultSet.getDouble("rate"));
                String fullTimeEmployeeString = partTimeEmployee.toString();
                return partTimeEmployee.toString();
            }
            else {
                return "This ID was not found among part time employees!";
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //Connecting SQL Statement used to calculate the payment of the Part Time Employee by ID to the Classes
    @Override
    public double getPaymentPTEByID(int id) {
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT rate*hoursworked as Payment FROM parttimeemployee WHERE employeeid=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            double payment=0;

            if (resultSet.next()){
                payment=resultSet.getDouble(("Payment"));
            }
            return payment;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    //Connecting SQL Statement used to update the information of the Part Time Employee by ID to the Classes
    @Override
    public boolean updatePTEByID(int id, String name, String surname, int age, String position, Double hoursWorked, Double rate) {
        Connection connection = null;
        try {
            connection = postgreSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM parttimeemployee WHERE employeeid=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE employee SET name=?, surname=?, age=?, position=?  WHERE employeeid=?; UPDATE parttimeemployee SET hoursworked=?, rate=? WHERE employeeid=?;");
                preparedStatement2.setString(1, name);
                preparedStatement2.setString(2, surname);
                preparedStatement2.setInt(3, age);
                preparedStatement2.setString(4, position);
                preparedStatement2.setInt(5, id);
                preparedStatement2.setDouble(6, hoursWorked);
                preparedStatement2.setDouble(7, rate);
                preparedStatement2.setInt(8, id);
                preparedStatement2.execute();
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
