package com.example.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DatosController implements Initializable {

    @FXML
    private Label emailRecibido;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void recogerDatos(String emailPasado, String passwordPasada){
        emailRecibido.setText(emailPasado);
        System.out.println(passwordPasada);
        leerFichero("src/main/java/com/example/proyectofinal/database.txt", emailPasado, passwordPasada);
    }

    public static void leerFichero(String archivo, String usuario, String contrasenia){
        String cadena;
        Boolean encontrado;
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(fr);
            while ((cadena = bf.readLine())!=null){
                //System.out.println(cadena);
                if(cadena.equalsIgnoreCase(usuario)){
                    System.out.println("se ha encontrado");
                    System.out.println(cadena);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
