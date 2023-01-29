package com.first.employee;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListController {
    @FXML private ListView<Employee> listEmployees;

    @FXML public void onClose() {
        System.exit(0);
    }

    @FXML public void btnLoadOnClick() {
        EmployeeCollection ec = new EmployeeCollection();

        listEmployees.setItems(FXCollections.observableList(ec.getEmployees()));
        listEmployees.setEditable(false);
        listEmployees.setVisible(true);


    }

}
