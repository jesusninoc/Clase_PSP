import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Proceso3 {

    String line2;
    Process hijo2;

    {
        try {
            hijo2 = new ProcessBuilder("java","src/Proceso4.java").start();

            BufferedReader br2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream()));

            PrintStream ps2 = new PrintStream(hijo2.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

            System.out.println("Introduzca el DNI asociado al pedido: " );

            line2 = in.readLine();

            ps2.println(line2);

            line2 = br2.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
