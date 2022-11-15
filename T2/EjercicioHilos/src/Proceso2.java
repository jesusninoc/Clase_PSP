import java.io.BufferedReader;
import java.io. IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Proceso2 {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1,"1234A","Naiara","Gonzalez",22,600999888,"naiaragonzalez@gmail.com");
        Cliente cliente2 = new Cliente(2,"1234B","Angel","Castro",20,600999777,"angelcastro@gmail.com");
        Cliente cliente3 = new Cliente(3,"1234C","Juan","Manizales",26,600999666,"juanmanizales@gmail.com");
        Cliente cliente4 = new Cliente(4,"1234D","Ricardo","Sangronis",19,600999555,"ricardosangronis@gmail.com");
        Cliente cliente5 = new Cliente(5,"1234E","Angelica","Garcia",22,600999444,"angelicagarcia@gmail.com");

        Pedido pedido1 = new Pedido("1234A","Memoria RAM","32 GB",1,1, 99.98);
        Pedido pedido2 = new Pedido("1234B","Disco duro SSD","1 TB",2,1, 149.99);
        Pedido pedido3 = new Pedido("1234C","Tarjeta gráfica","RTX Gaming - 12 GB",3,1, 399.91);
        Pedido pedido4 = new Pedido("1234D","Caja PC","Con luceS LED RGB",4,1, 59.96);
        Pedido pedido5 = new Pedido("1234E","Teclado USB","Color negro",5,1, 6.99);

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);

        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);
        listaPedidos.add(pedido4);
        listaPedidos.add(pedido5);

        String leer;


        try {

        // BufferedReader para recibir datos del padre


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();

            leer = br.readLine();

            for (Cliente item: listaClientes) {

                if(leer.equalsIgnoreCase(item.getDni())){
                    for(Pedido item2: listaPedidos){
                        {
                            System.out.println("Mostrando cliente con DNI: " + leer + item.mostrarDatos() + "   " + "Mostrando pedido del cliente con DNI: " + leer + ": " + item2.mostrarDatosPedidos() );
                        }
                    }
                    //System.out.println("Mostrando cliente con DNI " + leer + ": " + item.mostrarDatos());
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

    private static class Pedido{
        String dni, producto, descripcion;
        int id_pedido, cantidad;
        double precio_unidad, precio_total;

        public Pedido(String dni, String producto, String descripcion, int id_pedido, int cantidad, double precio_unidad) {
            this.dni = dni;
            this.producto = producto;
            this.descripcion = descripcion;
            this.id_pedido = id_pedido;
            this.cantidad = cantidad;
            this.precio_unidad = precio_unidad;
            this.precio_total = (double)cantidad * precio_unidad;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getId_pedido() {
            return id_pedido;
        }

        public void setId_pedido(int id_pedido) {
            this.id_pedido = id_pedido;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getPrecio_unidad() {
            return precio_unidad;
        }

        public void setPrecio_unidad(double precio_unidad) {
            this.precio_unidad = precio_unidad;
        }

        public double getPrecio_total() {
            return precio_total;
        }

        public void setPrecio_total(double precio_total) {
            this.precio_total = precio_total;
        }

        private String mostrarDatosPedidos(){
            String mensaje;
            mensaje = ("  ID: " + id_pedido +
                    "  DNI: " + dni +
                    "  Producto: " + producto +
                    "  Descripcion: " + descripcion +
                    "  Cantidad: " + cantidad +
                    "  Precio unidad: " + precio_unidad + "€" +
                    "  Total: " + precio_unidad + "€ ");
            return mensaje;
        }
    }

}

