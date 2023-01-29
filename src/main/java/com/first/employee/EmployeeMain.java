package com.first.employee;

public class EmployeeMain {
    public static void main(String[] args) {
//        EmployeeDatabaseConnection db = EmployeeDatabaseConnection.getInstance();
        EmployeeCollection ec = new EmployeeCollection();
        System.out.println(EmployeeMain.class.getResource("..//employee.fxml"));
    }
}
