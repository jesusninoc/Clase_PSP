import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.*;

public class ServidorSSL {

    public static void main(String[] args) {

        int puerto = 6000;

        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket servidorSSL = (SSLServerSocket) sfact.createServerSocket(puerto);
            // Meter hilo aqui para poder crear una conexion concurrente, que el server escuche tod0 el rato al client
            SSLSocket cliente = null;

            DataInputStream flujoEntrada = null;
            DataOutputStream flujoSalida = null;

            for (int i = 0; i < 5; i++) {

                cliente = (SSLSocket) servidorSSL.accept();

                flujoEntrada = new DataInputStream(cliente.getInputStream());
                System.out.println(flujoEntrada.readUTF());
            }

            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
            servidorSSL.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
