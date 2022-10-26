import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Padre {

    public static void main(String args[]) {

        String line;
        Cliente cliente1 = new Cliente(01,"1234X","Naiara","Gonzalez",22,600999888,"naiaragonzalez@gmail.com");
        Cliente cliente2 = new Cliente(02,"1234Y","Juan","Manizales",26,600999777,"juanmanizales@gmail.com");
        Cliente cliente3 = new Cliente(03,"1234Z","Angel","Castro",20,600999666,"angelcastro@gmail.com");
        Cliente cliente4 = new Cliente(04,"1234A","Ricardo","Sangronis",18,600999555,"ricardosangronis@gmail.com");
        Cliente cliente5 = new Cliente(05,"1234B","Angelica","Silvestre",22,600999444,"angelicasilvestre@gmail.com");
        ArrayList<Cliente> listaClientes  = new ArrayList<>();


        try {

// Llamar a la clase Hijo compilada anteriormente

            Process hijo = new ProcessBuilder("java", "Hijo").start();

// Buffer para datos del proceso hijo

            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

// Stream salida

            PrintStream ps = new PrintStream(hijo.getOutputStream(), true);

// Buffer que lee de consola

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enviar un mensaje al proceso hijo:");

// Enviar mensaje al hijo

            line = in.readLine();

            ps.println(line);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cliente{
    int id, telefono,edad;
    String nombre,apellido,dni,correo;

    public Cliente(){}
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

    public void mostrarDatos(){
        System.out.println("ID: " + id + "\n" +
                "DNI: " + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Telefono: : " + telefono + "\n" +
                "Correo: " + correo + "\n");
    }
}