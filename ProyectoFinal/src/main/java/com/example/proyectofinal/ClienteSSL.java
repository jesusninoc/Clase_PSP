package com.example.proyectofinal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import javax.net.ssl.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ClienteSSL  {
    public static void main(String[] args) throws Exception {

        String correo, asunto, mensaje;

        DatosController datosController = new DatosController();
        datosController.acciones();

        String Host = "localhost";
        int puerto = 6000;//puerto remoto

        // Propiedades JSSE)
        System.setProperty("javax.net.ssl.trustStore","src/main/java/com/example/proyectofinal/AlmacenSrv2");
        System.setProperty("javax.net.ssl.trustStorePassword","1234567");

        System.out.println("PROGRAMA CLIENTE INICIADO....");

        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket Cliente  = (SSLSocket) sfact.createSocket(Host, puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

        // ENVIO UN SALUDO AL SERVIDOR
        flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

        // EL servidor ME ENVIA UN MENSAJE
        System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());

        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        Cliente.close();

    }

    private static void enviarEmail(String destinatario, String asunto, String cuerpo){
        // Email de envío
        String remitente = "remitente@gmail.com";
        // Clave de al app
        String claveEmail = "clave";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP de Google
        props.put("mail.smtp.user", remitente); // Remitente del email
        props.put("mail.smtp.clave", claveEmail); // Clave de la cuenta
        props.put("mail.smtp.auth",true); // Usar autenticacion mediante usuario y clave
        props.put("mail.smtp.starttls.enable", true); // Conectarse de manera segura al servidor SMTP
        props.put("mail.smtp.port","587"); // Puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(destinatario)));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveEmail);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
