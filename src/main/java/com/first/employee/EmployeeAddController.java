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
        Employee employee = new Employee(employeeName.getText(), employeeRole.getText(), employeeJoinDate.getValue(), employeeDOB.getValue());
        EmployeeCollection ec = new EmployeeCollection();
        ec.addCustomerRecord(employee);
        doHouseKeepings();
    }

    @FXML
    public void btnClose() {
        doHouseKeepings();
        employeeName.getScene().getWindow().hide();
    }

    private void doHouseKeepings() {
        employeeName.clear();
        employeeRole.clear();
        EmployeeListController elc = new EmployeeListController();
//        elc.btnLoadOnClick();
    }
}
