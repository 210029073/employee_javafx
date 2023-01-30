package com.first.employee;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListController {
    @FXML private TextField txtSearchBar;
    @FXML private ListView<String> listEmployeesName;
    @FXML private ListView<String> listEmployeesRole;
    @FXML private ListView<LocalDate> listEmployeesJoinDate;

    @FXML public void onClose() {
        System.exit(0);
    }

    @FXML public void btnLoadOnClick() {
        EmployeeCollection ec = new EmployeeCollection();

        List<String> name = new ArrayList<>();
        for(Employee employee : ec.getEmployees()) {
            name.add(employee.getName());
        }

        listEmployeesName.setItems(FXCollections.observableList(name));
        listEmployeesName.setEditable(false);
        listEmployeesName.setVisible(true);

        List<String> role = new ArrayList<>();
        for(Employee employee : ec.getEmployees()) {
            role.add(employee.getRole());
        }

        listEmployeesRole.setItems(FXCollections.observableList(role));
        listEmployeesRole.setEditable(false);
        listEmployeesRole.setVisible(true);

        List<LocalDate> join_date = new ArrayList<>();
        for(Employee employee : ec.getEmployees()) {
            join_date.add(employee.getJoin_date());
        }

        listEmployeesJoinDate.setItems(FXCollections.observableList(join_date));
        listEmployeesJoinDate.setEditable(false);
        listEmployeesJoinDate.setVisible(true);
    }

    @FXML
    public void searchByEmployeeName() {
        EmployeeCollection ec = new EmployeeCollection();
        String input = txtSearchBar.getText();
        for(Employee e : ec.getEmployees()) {
            if(!e.getName().equals(input)) {
                listEmployeesJoinDate.setEditable(true);
                ec.getEmployees().remove(e);

                listEmployeesJoinDate.refresh();
                listEmployeesJoinDate.setEditable(false);
            }
        }
    }

}
