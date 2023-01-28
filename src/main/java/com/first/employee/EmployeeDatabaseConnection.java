package com.first.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final class EmployeeDatabaseConnection<E> {
    private final String urlDBConnection;
    private final String username;
    private final String password;

    private List<Employee> results;
    private ResultSet rs;

    private static EmployeeDatabaseConnection employeeDB;

     EmployeeDatabaseConnection() {
        this.urlDBConnection = "jdbc:mysql://localhost:3306/employee";
        this.username = "user";
        this.password = "1234";
        rs = null;
        this.results = new ArrayList<Employee>();
        System.out.println("Loading Driver...");
//        attemptConnection();
        populateEmployeeCollection();
     }

    private void attemptConnection() {


        try {
            Connection connection = DriverManager.getConnection(urlDBConnection, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to Connect to the database.");
        }

        System.out.println("Database has successfully established an connection!");

    }

    public Connection getConnection() {
        try(
                Connection connection = DriverManager.getConnection(urlDBConnection, username, password)
        ) {
            System.out.println("Query successfully been processed in transaction!");
            return connection;
        }

        catch(SQLException e) {
            System.out.println("Database Failed to Connect: " + e.getMessage());
        }

        return null;
    }


    private void populateEmployeeCollection() {
        try {
            Connection connection = DriverManager.getConnection(urlDBConnection, username, password);
            System.out.println("Database has been successfully connected!");

            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getObject(4, LocalDate.class),
                        resultSet.getObject(5, LocalDate.class));
                results.add(employee);
            }
        }
        catch(SQLException e) {
            System.out.println("Database Failed to Connect: " + e.getMessage());
        }
    }

    public List<Employee> getResults() {
        return results;
    }

    static EmployeeDatabaseConnection getInstance() {
         if (employeeDB == null) {
             return new EmployeeDatabaseConnection();
         } else return employeeDB;
    }
}
