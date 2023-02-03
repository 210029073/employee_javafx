package com.first.employee;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

final class EmployeeDatabaseConnection {
    private final String urlDBConnection;
    private final String username;
    private final String password;

    private List<Employee> results;
    private ResultSet rs;

    private static EmployeeDatabaseConnection employeeDB;

     private EmployeeDatabaseConnection() {
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
        try {
            return DriverManager.getConnection(urlDBConnection, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Deprecated
    private void populateEmployeeCollection() {
        try {
            Connection connection = this.getConnection();
            System.out.println("Database has been successfully connected!");

            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                Date join_date = (java.sql.Date) resultSet.getObject("join_date");
                Date date_of_birth = (java.sql.Date) resultSet.getObject(5);

                Employee employee = new Employee(resultSet.getString(2),
                        resultSet.getString(3),
                        join_date.toLocalDate(),
                        date_of_birth.toLocalDate());

                results.add(employee);
            }
        }
        catch(SQLException e) {
            System.out.println("Database Failed to Connect: " + e.getMessage());
        }
    }

    @Deprecated
    public void addCustomerRecord(Employee employee) {
         try {
            Connection connection = DriverManager.getConnection(urlDBConnection, username, password);
//            connection.nativeSQL("INSERT INTO employee(name, role, join_date, date_of_birth) VALUES (" +  employee.getName() + "," + employee.getRole() + "," + employee.getJoin_date() + ", " +employee.getDate_of_birth() + ")");
//            connection.createStatement().executeUpdate("INSERT INTO employee_ (name, role, join_date, date_of_birth) + VALUES (" +  employee.getName() + "," + employee.getRole() + ","
//                    + Date.valueOf(employee.getJoin_date())
//                    + ", " + Date.valueOf(employee.getDate_of_birth()) + ")");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO employee(`name`, `role`, join_date, date_of_birth, age)" + "VALUE (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getRole());
            statement.setObject(3, employee.getJoin_date());
            statement.setObject(4 , employee.getDate_of_birth());
            statement.setInt(5, LocalDate.now().getYear() - employee.getDate_of_birth().getYear());
            statement.executeUpdate();
            System.out.println("Successfully added a customer record!");
         }

         catch (SQLException e) {
             System.out.println("Database has failed to add a new customer record: " + e.getMessage());
         }
    }

    @Deprecated
    public List<Employee> getResults() {
        return results;
    }

    static EmployeeDatabaseConnection getInstance() {
         if (employeeDB == null) {
             return new EmployeeDatabaseConnection();
         } else return employeeDB;
    }
}
