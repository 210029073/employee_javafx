package com.first.employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeComponent extends Application  {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(EmployeeComponent.class.getResource("/com.first.employee/employee1.fxml"));
//            l.setController(new EmployeeListController());
            VBox root = l.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("List Employees");
            stage.setResizable(false);
            stage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
//        System.out.println("Testing 1234");
    }
}
