import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;

public class Hijo3 extends Thread{

    private String dni;
    private String nombre;

    public Hijo3(String nombre){
        this.nombre = nombre;
    }

    public static void main(String[] args) {

        String leer;

        try {

// BufferedReader para recibir datos del padre

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            leer = new String();

            leer = br.readLine() + " Mensaje procesado";


            System.out.println(leer);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void run() {

    }
}

