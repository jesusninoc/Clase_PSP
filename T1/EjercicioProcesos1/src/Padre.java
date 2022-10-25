import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {

    public static void main(String args[]) {

        String line;

        try {

            // En esta clase se debe tener un scanner que pregunte que cliente se desea buscar en el hijo
// Llamar a la clase Hijo compilada anteriormente

            Process hijo = new ProcessBuilder("java","Hijo").start();

// Buffer para leer los datos del proceso hijo

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

// Stream salida

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

            BufferedReader in = new BufferedReader(new InputStreamReader (System.in));

            System.out.println("Enviar un mensaje al proceso hijo:");

// Enviar mensaje al hijo

            line = in.readLine();

            ps.println(line);

// Recibir información del padre 

            line = br.readLine();

            System.out.println(line) ;

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}