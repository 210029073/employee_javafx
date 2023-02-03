package com.first.employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCollection {
    private List<Employee> employees;

    public EmployeeCollection(List<Employee> employees) {
        this.employees = employees;
        this.populateEmployeeCollection();
    }

    public EmployeeCollection() {
        this(new ArrayList<>());
    }

//    private void populateEmployeeCollection() {
//        EmployeeDatabaseConnection db = EmployeeDatabaseConnection.getInstance();
//
//        this.employees = db.getResults();
//    }

    private void populateEmployeeCollection() {
        try {
            Connection connection = EmployeeDatabaseConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                Date join_date = (java.sql.Date) resultSet.getObject("join_date");
                Date date_of_birth = (java.sql.Date) resultSet.getObject(5);

                Employee employee = new Employee(resultSet.getString(2),
                        resultSet.getString(3),
                        join_date.toLocalDate(),
                        date_of_birth.toLocalDate());

                this.employees.add(employee);
            }
        }
        catch(SQLException e) {
            System.out.println("Database Failed to Connect: " + e.getMessage());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addCustomerRecord(Employee employee) {
        try {
            Connection connection = EmployeeDatabaseConnection.getInstance().getConnection();
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
}
