import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Proceso1 extends Thread{

    @Override
    public void run (){
        String line;

        try {
            Process hijo = new ProcessBuilder("java","src/Proceso2.java").start();

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

            System.out.println("Introduzca el DNI del cliente a buscar: " );

            line = in.readLine();

            ps.println(line);

            line = br.readLine();

            // System.out.println(line + "ola proceso1") ;

        }catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }
}
