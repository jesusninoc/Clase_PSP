import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Proceso3 extends Thread{

    public void run () {
        // Segunda lista de clientes
        Cliente cliente1 = new Cliente(1,"5678A","Angel","Lopez",20,600999888,"angellopez@gmail.com");
        Cliente cliente2 = new Cliente(2,"5678B","Cristina","Lopez",24,600999777,"cristinalopez@gmail.com");
        Cliente cliente3 = new Cliente(3,"5678C","Jessica","Marulanda",24,600999666,"jessicamarulanda@gmail.com");
        Cliente cliente4 = new Cliente(4,"5678D","Patricia","Fraile",19,600999555,"patriciafraile@gmail.com");
        Cliente cliente5 = new Cliente(5,"5678E","Andrea","Fernandez",31,600999444,"andreafernandez@gmail.com");

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);

        String leer;


        try {

// BufferedReader para recibir datos del padre


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();

            leer = br.readLine();

            for (Cliente item: listaClientes) {
                int id, telefono, edad;
                String nombre, apellido, dni, correo,mensaje;

                if(leer.equalsIgnoreCase(item.getDni())){
                    System.out.println("Mostrando cliente con DNI " + leer + " de la 2da lista: " + item.mostrarDatos());
                }
            }

            //System.out.println("Su palabra es " + leer +  " || Numero de caracteres: " + leer.length());


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static class Cliente{
        int id, telefono, edad;
        String nombre, apellido, dni, correo;

        public Cliente() {
        }

        public Cliente(int id, String dni, String nombre, String apellido, int edad, int telefono, String correo) {
            this.id = id;
            this.telefono = telefono;
            this.edad = edad;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.correo = correo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        private String mostrarDatos(){
            String mensaje;
            mensaje = ("  ID: " + id +
                    "  DNI: " + dni +
                    "  Nombre: " + nombre +
                    "  Apellido: " + apellido +
                    "  Edad: " + edad +
                    "  Telefono: : " + telefono +
                    "  Correo: " + correo);
            return mensaje;
        }
    }
}
