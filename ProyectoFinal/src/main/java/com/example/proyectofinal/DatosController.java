package com.example.proyectofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DatosController implements Initializable {

    @FXML
    private TextField emailDestino, asuntoEmail;

    @FXML
    private TextArea mensajeEmail;

    @FXML
    private Button botonEnviar;

    private String emailRecibido2, contraseniaRecibida;

    //public String ficheroBBDD = "src/main/java/com/example/proyectofinal/database.txt";

    File ficheroBBDD = new File("src/main/java/com/example/proyectofinal/database.txt");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void recogerDatos(String emailPasado, String passwordPasada) {
        emailRecibido2 = emailPasado;
        contraseniaRecibida = passwordPasada;

        leerFichero(ficheroBBDD, emailPasado, passwordPasada);
    }

    public void leerFichero(File fichero, String usuario, String contrasenia) {

        String cadena;


        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);


            while ((cadena = br.readLine()) != null) {

                if (cadena.equalsIgnoreCase(usuario)) {
                    System.out.println("Se ha encontrado el usuario:");
                    System.out.println(cadena);

                } else if (!cadena.equalsIgnoreCase(usuario)) {
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
    }
}
