package com.first.employee;

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

    private void populateEmployeeCollection() {
        EmployeeDatabaseConnection db = EmployeeDatabaseConnection.getInstance();

        this.employees = db.getResults();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
