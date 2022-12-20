import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        Socket cliente;
        Integer numResultados;

        try {
            cliente = new Socket("localhost",9999);

            PrintStream out = new PrintStream(cliente.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduzca el numero de personas a generar: ");
            numResultados = scanner.nextInt();
            out.println(numResultados);

            System.out.println(in.readLine());


            out.close();
            in.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}