package com.company.Data;

import com.company.Data.Interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements IDB{

    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/JavaProject";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl, "postgres", "06022002j");

            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
