package com.company.Repository;

import com.company.Data.Interfaces.IDB;
import com.company.Entities.Employee;
import com.company.Entities.FullTimeEmployee;
import com.company.Repository.Interfaces.IFTERepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FTERepository implements IFTERepository {
    private final IDB postgreSQL;
    public FTERepository (IDB postgreSQL){
        this.postgreSQL=postgreSQL;
    }
   @Override
    public boolean addFullTimeEmployee(FullTimeEmployee fullTimeEmployee) {
        Connection connection = null;
        try{
            connection =postgreSQL.getConnection();
            /*adding new full time employee by the SQL code 
            INSERT INTO employee (employeeID, name, surname, age, position, dateofagreement, expiredate) VALUES (?, ?, ?, ?, ?, ?, ?); INSERT INTO fulltimeemployee (employeeID, salary) VALUES (?, ?);
            */
            String sql = "INSERT INTO employee (employeeID, name, surname, age, position, dateofagreement, expiredate) VALUES (?, ?, ?, ?, ?, ?, ?); INSERT INTO fulltimeemployee (employeeID, salary) VALUES (?, ?); ";
            PreparedStatement st = connection.prepareStatement (sql);
            st.setInt(1, FullTimeEmployee.getEmployeeID());
            st.setString(2, FullTimeEmployee.getName());
            st.setString(3, FullTimeEmployee.getSurname());
            st.setInt(4, FullTimeEmployee.getAge());
            st.setString(5, FullTimeEmployee.getPosition());
            st.setDate(6, Date.valueOf(FullTimeEmployee.getDateOfAgreement()));
            st.setDate(7, Date.valueOf(FullTimeEmployee.getExpireDate()));
            st.setInt(8, FullTimeEmployee.getEmployeeID());
            st.setDouble(9, FullTimeEmployee.getSalary());
            st.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            Statement preparedStatement = connection.createStatement();
            /*
            for getting all full time employees was used the SQL code
            SELECT * FROM fulltimeemployee INNER JOIN employee ON employee.employeeid=fulltimeemployee.employeeid;
            */
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM fulltimeemployee INNER JOIN employee ON employee.employeeid=fulltimeemployee.employeeid;");
            List<FullTimeEmployee> fulltimeemployees=new LinkedList<>();
            while (resultSet.next()){
                FullTimeEmployee fullTimeEmployee=new FullTimeEmployee (resultSet.getInt("employeeid"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("position"),
                        resultSet.getDate("dateofagreement").toLocalDate(),
                        resultSet.getDate("expiredate").toLocalDate(),
                        resultSet.getDouble("salary"));
                fulltimeemployees.add(fullTimeEmployee);
            }
            return fulltimeemployees;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public FullTimeEmployee getFTEByID(int id){
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            /*
            for getting full time employee by ID was used the SQL Code
            SELECT * FROM employee WHERE employeeid=?;
            */
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM employee WHERE employeeid=?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            FullTimeEmployee fullTimeEmployee=new FullTimeEmployee();

            if (resultSet.next()){
                fullTimeEmployee.setEmployeeID(resultSet.getInt("employeeid"));
                fullTimeEmployee.setName(resultSet.getString("name"));
                fullTimeEmployee.setSurname(resultSet.getString("surname"));
                fullTimeEmployee.setAge(resultSet.getInt("age"));
                fullTimeEmployee.setPosition(resultSet.getString("position"));
                fullTimeEmployee.setDateOfAgreement(resultSet.getDate("dateofagreement").toLocalDate());
                fullTimeEmployee.setExpireDate(resultSet.getDate("expiredate").toLocalDate());
                fullTimeEmployee.setSalary(resultSet.getDouble("salary"));

            }
            String fullTimeEmployeeString = fullTimeEmployee.toString();
            return fullTimeEmployee;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public double getPaymentFTEByID(int id) {
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            /*
            for getting payment of full time employees by id was used SQL code
            SELECT salary*12 as Payment FROM fulltimeemployee WHERE employeeid=?
            */
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT salary*12 as Payment FROM fulltimeemployee WHERE employeeid=?");
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
}
