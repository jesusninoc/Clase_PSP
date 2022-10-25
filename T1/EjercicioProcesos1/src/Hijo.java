import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;

public class Hijo{

    public static void main(String[] args) {

        String leer;

        try {

// BufferedReader para recibir datos del padre

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer=br.readLine() + " Mensaje procesado";
            System.out.println(leer);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}