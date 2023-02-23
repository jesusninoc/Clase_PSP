package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

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

                // Recogida de email y password
                MessageDigest md;
                String emailRecibido = emailField.getText();
                String passwordRecibida = passwordField.getText();
                String passwordHasheada;

                try {
                    // Hasheado de password
                    md = MessageDigest.getInstance("SHA512");
                    byte dataByte[] = passwordRecibida.getBytes();
                    md.update(dataByte);
                    byte resumen[] = md.digest();

                    //System.out.println(new String(resumen));
                    passwordHasheada = Hexadecimal(resumen);
                    //System.out.println(passwordHasheada);


                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }

                //System.out.println(emailRecibido);
                //System.out.println(passwordRecibida);

                // Paso de datos a la siguiente ventana

                Stage ventanaDatos = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("datos.fxml"));

                Scene scene = null;

                try {
                    Parent parent = fxmlLoader.load();
                    scene = new Scene(parent, 600, 600);
                    DatosController datosController = fxmlLoader.getController();
                    datosController.recogerDatos(emailRecibido, passwordHasheada);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                ventanaDatos.setScene(scene);
                ventanaDatos.show();
            }
        }
    }

    static String Hexadecimal(byte[] resumen){
        String hex = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if(h.length() == 1){
                hex += "0";
            }
            hex+=h;
        }

        return hex.toUpperCase();
    }

}