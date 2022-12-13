import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {


    public static void main(String[] args) {

        Socket cliente;

        // printstream -> escribir
        PrintStream p;

        // bufferedreader -> lee la informacion
        //BufferedReader b;

        {
            try {
                // requiere de una ip a la que te vas a conectar y un puerto
                cliente = new Socket("192.168.2.100",1234);

                // Enviar informacion al Servidor

                p = new PrintStream(cliente.getOutputStream());
                p.println("hola");

                //b = cliente.getInputStream();

                //cliente.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
