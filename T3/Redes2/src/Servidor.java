import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        // Primero se ejecuta el servidor y despues, el cliente
        // Cuando la conexion ha sido existosa, terminan ambas ejecuciones a la vez
        // Siempre hay que cerrar las conexiones al final con el .close para evitar errores:
        // Address already in use: bind

        ServerSocket servidor;
        BufferedReader b;

        {
            try {
                servidor = new ServerSocket(1234);
                // .accept: metodo que acepta todas las conexiones que lleguen
                // 1º crear cliente que recibe la informacion de tipo socket
                Socket cliente = servidor.accept();

                b = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                System.out.println(b.readLine());

                // .getLocalPort: muestra el puerto local del servidor
                //System.out.println(cliente.getLocalPort());

                // .getPort: muestra el puerto en el que esta conectado el cliente
                // System.out.println(cliente.getPort());

                cliente.close();
                servidor.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
