package com.first.employee;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        boolean isFound = false;
        
        for(Employee e : ec.getEmployees()) {
            if(e.getName().equals(input)) {
                updateList(e, input);
                isFound = true;
                break;
            } else if (e.getRole().equals(input)) {
                updateList(e, input);
                isFound = true;
                break;
            }
            //handle error
            else {
            	isFound = false;
            }
        }
        
        if(!isFound) {
        	Alert alert = new Alert(AlertType.ERROR, "Cannot find the employee specified in your search criteria.", ButtonType.OK);
        	alert.setTitle("Error: Cannot find employee");
            alert.setHeaderText("Cannot find employee");
            alert.showAndWait();
    		if(alert.getResult() == (ButtonType.OK)) {
        		txtSearchBar.clear();
        		alert.close();
    		}
        }

    }

    private void updateList(Employee e, String input) {
        List<String> result = new ArrayList<>();
        List<LocalDate> resultDate = new ArrayList<>();
        List<String> resultRole = new ArrayList<>();

        listEmployeesName.setEditable(true);
        result.add(e.getName());
        listEmployeesName.setItems(FXCollections.observableList(result));
        listEmployeesName.refresh();
        listEmployeesName.setEditable(false);

        listEmployeesJoinDate.setEditable(true);
        resultDate.add(e.getJoin_date());
        listEmployeesJoinDate.setItems(FXCollections.observableList(resultDate));
        listEmployeesJoinDate.refresh();
        listEmployeesJoinDate.setEditable(false);

        listEmployeesRole.setEditable(true);
        resultRole.add(e.getRole());
        listEmployeesRole.setItems(FXCollections.observableList(resultRole));
        listEmployeesRole.refresh();
        listEmployeesRole.setEditable(false);
    }

    @FXML
    public void openAboutUs() {
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("About");
        stage.setResizable(false);

        VBox vbox = new VBox();

        String msg = "App used for displaying Employee Details"
                + "\n" + "Used MySQL as a Database for the Backend." +
                "\n\n\n\n" + "Created by Ibrahim Ahmad";

        Label lblMsg = new Label(msg);
        lblMsg.textAlignmentProperty().set(TextAlignment.CENTER);
        lblMsg.setPadding(new Insets(10,10,10,10));

        vbox.getChildren().add(lblMsg);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
        stage.show();
        stage.showAndWait();
    }


}
