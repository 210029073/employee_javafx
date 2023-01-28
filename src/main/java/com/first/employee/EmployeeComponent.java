package com.first.employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EmployeeComponent extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader l = new FXMLLoader();
            l.setLocation(new URL("employee.fxml"));
            l.setController(new EmployeeListController());
            Pane root = l.load();

            Scene scene = new Scene(root, 500,500);
            stage.setScene(scene);
            stage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
