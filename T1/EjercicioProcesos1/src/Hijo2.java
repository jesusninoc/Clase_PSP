import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hijo2{

    public static void main(String[] args) {

        String leer;

        try {

// BufferedReader para recibir datos del padre


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();

            leer = br.readLine();

            System.out.println("Su palabra es " + leer +  " || Numero de caracteres: " + leer.length());


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
