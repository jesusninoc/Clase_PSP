import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Padre {

    private String nombre;

    public Padre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {

        String line;

        try {
            Process hijo = new ProcessBuilder("java","src/Hijo.java").start();

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca los DNI's a buscar: ");

            line = in.readLine();

            ps.println(line);

            line = br.readLine();

            System.out.println(line);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
