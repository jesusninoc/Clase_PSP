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
            String dni2;

            try {

                Hijo3 hilo = new Hijo3("juan");

// Llamar a la clase Hijo compilada anteriormente

                Process hijo = new ProcessBuilder("java","src/Hijo3.java").start();

// Buffer para datos del proceso hijo

                // nos conectamos al stream del hijo
                BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));


// Stream salida
                // envia el mensaje
                PrintStream ps = new PrintStream(hijo.getOutputStream(), true);
                PrintStream ps2 = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

                BufferedReader in = new BufferedReader(new InputStreamReader(System. in));

                System.out.println("Enviar un DNI:");

// Enviar mensaje al hijo

                dni = in.readLine();

                System.out.println("Envia el 2do DNI:");

                dni2 = in.readLine();

                ps.println(dni);
                ps2.println(dni2);


// Recibir información del padre

                dni = br.readLine();
                dni2 = br.readLine();

                //System.out.println(dni + "fdof");
                //System.out.println(dni2+"ofejpe");

            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
    }
