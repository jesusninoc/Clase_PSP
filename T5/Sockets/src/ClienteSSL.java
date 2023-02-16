import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClienteSSL {

    public static void main(String[] args) {

        int puerto = 6000;

        SSLSocketFactory sfac = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            SSLSocket cliente = (SSLSocket) sfac.createSocket("localhost",puerto);

            DataInputStream flujoEntrada = null;
            DataOutputStream flujoSalida = null;

            flujoSalida = new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF("ola");


            flujoSalida.close();
            flujoEntrada.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
