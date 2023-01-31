package com.first.employee;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String role;
    private LocalDate join_date;
    private LocalDate date_of_birth;

    public Employee(String name, String role, LocalDate join_date, LocalDate date_of_birth) {
        this.name = name;
        this.role = role;
        this.join_date = join_date;
        this.date_of_birth = date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public LocalDate getJoin_date() {
        return join_date;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\tRole: " + getRole() + "\tJoined Us Since: " + getJoin_date() + "\tDOB: " + getDate_of_birth();
    }
}
