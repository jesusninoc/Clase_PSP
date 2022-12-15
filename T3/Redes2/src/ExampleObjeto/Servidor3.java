package ExampleObjeto;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.StreamTokenizer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor3 {
    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(9999);

            // otra manera de conectarse al puerto
            /*InetSocketAddress addr = new InetSocketAddress("127.0.0.1",9999);
            servidor.bind(addr);*/


            Socket cliente = servidor.accept();

            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

            Persona persona = new Persona("Juan");

            outObjeto.writeObject(persona);
            System.out.println(persona.getNombre());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
