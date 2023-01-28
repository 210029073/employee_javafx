package com.first.employee;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EmployeeListController {
    @FXML
    private ListView<Employee> listEmployees;

    @FXML
    private Button btnClose;

    @FXML
    public void initialize() {
        EmployeeCollection ec = new EmployeeCollection();
        listEmployees.setItems(FXCollections.observableList(ec.getEmployees()));
        listEmployees.setEditable(false);
    }

}
