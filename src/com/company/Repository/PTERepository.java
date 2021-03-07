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
    
    @Override
    public PartTimeEmployee getPTEByID(int id){
        Connection connection=null;
        try {
            connection = postgreSQL.getConnection();
            /*
            for getting part time employee by id was used SQL code
            SELECT * FROM employee WHERE employeeid=?
            
            */
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM employee WHERE employeeid=?");
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
            }
            String fullTimeEmployeeString = partTimeEmployee.toString();
            return partTimeEmployee;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
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
}
