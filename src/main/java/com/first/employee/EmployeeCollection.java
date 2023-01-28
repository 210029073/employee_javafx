package com.first.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeCollection {
    private ArrayList<Employee> employees;

    public EmployeeCollection(ArrayList<Employee> employees) {
        this.employees = employees;
        this.populateEmployeeCollection();
    }

    public EmployeeCollection() {
        this(new ArrayList<>());
    }

    private void populateEmployeeCollection() {
        EmployeeDatabaseConnection db = EmployeeDatabaseConnection.getInstance();
//        Connection connection = db.getConnection();
//        System.out.println("Database has been successfully connected!");

        this.employees = (ArrayList<Employee>) db.getResults();
    }

}
