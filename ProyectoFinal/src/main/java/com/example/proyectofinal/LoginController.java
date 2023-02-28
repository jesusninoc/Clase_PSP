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

import java.io.*;
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

    File ficheroBBDD = new File("src/main/java/com/example/proyectofinal/database.txt");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
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
                    byte[] dataByte = passwordRecibida.getBytes();
                    md.update(dataByte);
                    byte[] resumen = md.digest();

                    passwordHasheada = Hexadecimal(resumen);


                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }

                leerFichero(ficheroBBDD, emailRecibido, passwordHasheada);
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

    public void leerFichero(File fichero, String usuario, String contrasenia) {

        String cadena;


        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);


            while ((cadena = br.readLine()) != null) {

                if (cadena.equalsIgnoreCase(usuario+","+contrasenia)) {
                    System.out.println("Se ha encontrado el usuario:");
                    System.out.println(cadena);

                } else if (!cadena.equalsIgnoreCase(usuario+","+contrasenia)) {
                    System.out.println("No se ha encontrado el usuario");
                    System.out.println("- - - - Registrando nuevo usuario - - - - ");

                    File f = fichero;
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(fw);

                    pw.println(usuario + "," + contrasenia);

                    System.out.println("Se ha registrado el usuario con email " + usuario + " y contrasenia " + contrasenia);

                    pw.close();
                    bw.close();
                    break;
                }
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Paso a la siguiente ventana

        Stage ventanaDatos = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("datos.fxml"));

        Scene scene = null;

        try {
            Parent parent = fxmlLoader.load();
            scene = new Scene(parent, 600, 600);
            ventanaDatos.setTitle("Datos");
            ventanaDatos.setScene(scene);
            ventanaDatos.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}