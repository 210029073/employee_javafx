package com.first.employee;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EmployeeAddController {
    @FXML
    private TextField employeeName;

    @FXML
    private TextField employeeRole;

    @FXML
    private DatePicker employeeDOB;

    @FXML
    private DatePicker employeeJoinDate;

    @FXML
    public void btnConfirm() {
        System.out.println(employeeDOB.getValue());
    }

    @FXML
    public void btnClose() {

    }
}
