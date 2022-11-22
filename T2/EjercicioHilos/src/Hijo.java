import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hijo {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1, "1234A", "Naiara", "Gonzalez", 22, 600999888, "naiaragonzalez@gmail.com");
        Cliente cliente2 = new Cliente(2, "1234B", "Angel", "Castro", 20, 600999777, "angelcastro@gmail.com");
        Cliente cliente3 = new Cliente(3, "1234C", "Juan", "Manizales", 26, 600999666, "juanmanizales@gmail.com");
        Cliente cliente4 = new Cliente(4, "1234D", "Ricardo", "Sangronis", 19, 600999555, "ricardosangronis@gmail.com");
        Cliente cliente5 = new Cliente(5, "1234E", "Angelica", "Garcia", 22, 600999444, "angelicagarcia@gmail.com");

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);

        String leer;
        String[] contenido;


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();
            leer = br.readLine();
            contenido = leer.split(",");
            String dni1 = contenido[0];
            String dni2 = contenido[0];

            for (int i = 0; i < contenido.length; i++) {
                buscarCliente(contenido[i].toString(), listaClientes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static String buscarCliente(String dniBuscar1, ArrayList<Cliente> listaClientes) {

        String mensaje1=null;

        for (Cliente item : listaClientes) {
            if (dniBuscar1.equalsIgnoreCase(item.getDni())) {
                mensaje1 = "Mostrando cliente con DNI " + dniBuscar1 + ": " + item.mostrarDatos();
            }
        }
        return mensaje1;
    }

    private static class Cliente2 {

        private int id, telefono, edad;
        private String nombre, apellido, dni, correo;
        private int[] tramites;

        public Cliente2() {
        }

        public Cliente2(int id, String dni, String nombre, String apellido, int edad, int telefono, String correo, int[] tramites) {
            this.id = id;
            this.telefono = telefono;
            this.edad = edad;
            this.nombre = nombre;
            this.apellido = apellido;
            this.dni = dni;
            this.correo = correo;
            this.tramites = tramites;
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

        public int[] getTramites() {
            return tramites;
        }

        public void setTramites(int[] tramites) {
            this.tramites = tramites;
        }

        public String mostrarDatos() {
            String mensaje;
            mensaje = ("ID: " + id +
                    "\nDNI: " + dni +
                    "\nNombre: " + nombre +
                    "\nApellido: " + apellido +
                    "\nEdad: " + edad +
                    "\nTelefono: : " + telefono +
                    "\nCorreo: " + correo +
                    "\nNumero de tramites: " + tramites.length + "\n");
            return mensaje;
        }

        private static String buscarCliente(String dniBuscar1, String dniBuscar2, Cliente cliente, ArrayList<Cliente> listaClientes) {
           String mensaje1=null, mensaje2=null;

            for (Cliente item : listaClientes) {
                if (dniBuscar1.equalsIgnoreCase(item.getDni())) {
                    mensaje1 = "\nMostrando cliente con DNI " + dniBuscar1 + ": " + item.mostrarDatos();
                } else if (dniBuscar2.equalsIgnoreCase(item.getDni())) {
                    mensaje2 = "\nMostrando cliente con DNI " + dniBuscar2 + ": " + item.mostrarDatos();
                }
            }

            return mensaje1 + mensaje2;
        }
    }
}