package com.example.proyectofinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private String correoDestinatario, asuntoCorreo, mensajeCorreo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();

    }

    public void acciones() {
        botonEnviar.setOnAction(new ManejoPulsaciones());
    }

    public String instanciarMensaje() {
        mensajeCorreo = mensajeEmail.getText().toString();
        return asuntoCorreo;
    }

    public String instanciarAsunto() {
        asuntoCorreo = asuntoEmail.getText().toString();
        return asuntoCorreo;
    }

    public String instanciarCorreo() {
        correoDestinatario = emailDestino.getText().toString();
        return correoDestinatario;
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonEnviar){
                instanciarCorreo();
                instanciarAsunto();
                instanciarMensaje();
            }
        }
    }


}
