import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hijo{

    public static void main(String[] args) {


        String leer;

        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente(1,"Angelica","Rivas",690123123,"angelicarivas@gmail.com",23);
        Cliente cliente2 = new Cliente(2,"Naiara","Gonzalez",681234567,"naiariagonzalez@gmail.com",22);
        Cliente cliente3 = new Cliente(3,"Angel","Castro",654123456,"angelcastro@gmail.com",20);
        Cliente cliente4 = new Cliente(4,"Juan","Dominguez",654123789,"juandominguez@gmail.com",26);
        Cliente cliente5 = new Cliente(5,"Ricardo","Sangronis",654123789,"ricardosangronis@gmail.com",18);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);

        try {

            // En el hijo se crearia el ArrayList que contenga los clientes y mediante el BR, se buscaria el deseado para imprimir x consola

            // BufferedReader para recibir datos del padre

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();

            // leer= br.readLine() + " Mensaje procesado";
            // System.out.println(leer);
            leer = br.readLine();

            if(leer != null){
                for (Cliente item: listaClientes) {
                    if(leer.equals(item.getId())){
                        item.mostrarDatos();
                    }
                }
            }

            // if(leer.equalsIgnoreCase(""));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Cliente{
    String nombre, apellido, correo;
    int id, telefono, edad;

    public Cliente (){}
    public Cliente(int id, String nombre, String apellido, int telefono, String correo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.id = id;
        this.telefono = telefono;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
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

    public void mostrarDatos(){
        System.out.println("Id: " + id + "\n" +
                "Nombre: " + nombre +
                "Apellido: " + apellido +
                "Correo: " + correo +
                "Telefono: " + telefono +
                "Edad: " + edad);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", id=" + id +
                ", telefono=" + telefono +
                ", edad=" + edad +
                '}';
    }
}