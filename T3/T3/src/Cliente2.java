import java.io.*;
import java.net.Socket;

public class Cliente2 {

    public static void main(String[] args) {

        Socket cliente;

        try {
            cliente = new Socket("localhost",9999);

            PrintStream out = new PrintStream(cliente.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            out.println("hola papi");

            System.out.println(in.readLine());

            out.close();
            in.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
