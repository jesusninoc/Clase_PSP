import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Padre3 {

        public static void main(String args[]) {

            String dni;

            try {

                Hijo3 hilo = new Hijo3("juan");

// Llamar a la clase Hijo compilada anteriormente

                Process hijo = new ProcessBuilder("java","src/Hijo3.java").start();

// Buffer para datos del proceso hijo

                BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

// Stream salida

                PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

                BufferedReader in = new BufferedReader(new InputStreamReader(System. in));

                System.out.println("Enviar un DNI:");

// Enviar mensaje al hijo

                dni = in.readLine();

                ps.println(dni);

// Recibir información del padre

                dni = br.readLine();

                System.out.println(dni);

            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }

        }
    }

