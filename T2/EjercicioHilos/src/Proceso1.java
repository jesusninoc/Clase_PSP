import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Proceso1 {

    private String leer;
    public Proceso1(String leer){
        this.leer = leer;
    };

    String line;



    {
        try {
            Process hijo = new ProcessBuilder("java","src/Proceso2.java").start();

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

            // Buffer que lee de consola

            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            // System.out.println("Introduzcal el DNI del cliente a buscar: ");

            // Enviar mensaja al hijo
            //line = in.readLine();

            ps.println(line);

            // Recibir informacion del hijo

            line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}