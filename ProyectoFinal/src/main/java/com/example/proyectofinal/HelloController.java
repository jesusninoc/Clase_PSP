package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button logInButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {

    }

    private void acciones() {
        logInButton.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource()==logInButton){
                String emailRecibido = emailField.getText();
                System.out.println(emailRecibido);
            }
        }
    }

}