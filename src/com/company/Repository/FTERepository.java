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
    }}
