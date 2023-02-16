package com.example.dataapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppController {
    @FXML
    private Stage stage;
    @FXML
    private Button startButton = new Button(),
            submitButton = new Button(),
            clearButton = new Button();

    @FXML
    private TextField firstnameField = new TextField();
    @FXML
    private TextField lastnameField = new TextField();
    @FXML
    private TextField emailField = new TextField();

    @FXML
    private void toDataFields() throws  IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("data.fxml"));
        stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader,450,350));
    }

    @FXML
    private void saveUserInputToFile(ActionEvent event) throws IOException {
        //Így nyerjük ki az adatot a mezőkből
        String firstName = firstnameField.getText();
        String lastName = lastnameField.getText();
        String email = emailField.getText();

        FileWriter dataSaver = new FileWriter("/Volumes/SSD - 1.02 TB/Sapientia/I.Év - 2021 - 2023/II. Félév/Java/I. év 2021-22/OOP_magamra/labor_13/dataApp/userInput.txt");;
        if (email.contains("@gmail.com")){
            dataSaver.write(firstName + " " + lastName + " " + email);
        }
        dataSaver.close();

        firstnameField.clear();
        lastnameField.clear();
        emailField.clear();
    }

    @FXML
    private void clearField() {
        firstnameField.clear();
        lastnameField.clear();
        emailField.clear();
    }
}