import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Proceso4 extends Thread{

    @Override
    public void run(){
        String line2;

        try{
            Process hijo2 = new ProcessBuilder("java","src/Proceso3.java").start();

            BufferedReader br2 = new BufferedReader(new InputStreamReader(hijo2.getInputStream()));

            PrintStream ps2 = new PrintStream(hijo2.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader (System. in));

            System.out.println("Introduzca el DNI asociado al pedido: " );

            line2 = in.readLine();

            ps2.println(line2);

            line2 = br2.readLine();

            // System.out.println(line2 + "ola proceso2");

        }catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
