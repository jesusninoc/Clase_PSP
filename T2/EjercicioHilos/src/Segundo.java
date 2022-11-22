import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Segundo{


    public static void main(String[] args) {


        Matricula matricula1 = new Matricula("BMW","Rojo","5801KRE " );
        Matricula matricula2 = new Matricula("OPEL","Azul","1942LAO ");
        Matricula matricula3 = new Matricula("SEAT","Verde","9416KRM ");

        String[] listaId = new String[3];

        String idUno,idDos,idTres;


        ArrayList<Matricula> listaMatricula = new ArrayList<>();
        listaMatricula.add(matricula1);
        listaMatricula.add(matricula2);
        listaMatricula.add(matricula3);




        String leer;




        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();
            leer = br.readLine();

            listaId = leer.split(",");

            idUno = listaId[0];
            idDos = listaId[1];
            idTres = listaId[2];


            HiloUno hiloUno = new HiloUno(idUno);
            HiloUno hiloDos  = new HiloUno(idDos);
            HiloUno hiloTres = new HiloUno(idTres);

            hiloUno.start();
            hiloUno.join();
            hiloDos.start();
            hiloTres.start();


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static class Matricula{

        String nombre, color,id;

        public Matricula(String nombre, String color, String id) {
            this.nombre = nombre;
            this.color = color;
            this.id = id;
        }

        public void mostrarDatos(){
            System.out.printf("Nombre %s , Color %s , Id %s",nombre,color,id);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }


    }
    public static class HiloUno extends Thread{

        ArrayList<Segundo.Matricula> listaCoches = new ArrayList<>();

        String matricula = "";

        public HiloUno(String matricula){
            this.matricula = matricula;
        }

        public void agregarMatriculas(){

            Segundo.Matricula matricula1 = new Segundo.Matricula("BMW","Rojo","5801KRE");
            Segundo.Matricula matricula2 = new Segundo.Matricula("OPEL","Azul","1942LAO");
            Segundo.Matricula matricula3 = new Segundo.Matricula("SEAT","Verde","9416KRM");

            listaCoches.add(matricula1);
            listaCoches.add(matricula2);
            listaCoches.add(matricula3);
        }

        @Override
        public void run() {

            agregarMatriculas();
            for ( Segundo.Matricula item : listaCoches ) {
                if (item.getId().equalsIgnoreCase(matricula)){
                    item.mostrarDatos();
                }
            }
        }
    }
}