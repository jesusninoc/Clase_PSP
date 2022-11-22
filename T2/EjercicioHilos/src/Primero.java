import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Primero{

    public static void main(String[] args) {
        String line;

        try {


            Process hijo = new ProcessBuilder("java","src/Segundo.java").start();


            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));


            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);


            BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

            System.out.println("Introduzca el DNI: " );


            line = in.readLine();

            ps.println(line);


            line = br.readLine();

            System.out.println(line) ;

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}