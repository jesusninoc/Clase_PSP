import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Proceso4 {

    // Lista de pedidos

    public static void main(String[] args) {
        // Lista de pedidos

        Pedido pedido1 = new Pedido("1234A","Memoria RAM","32 GB",1,1, 99.98);
        Pedido pedido2 = new Pedido("1234B","Disco duro SSD","1 TB",2,1, 149.99);
        Pedido pedido3 = new Pedido("1234C","Tarjeta gráfica","RTX Gaming - 12 GB",3,1, 399.91);
        Pedido pedido4 = new Pedido("1234D","Caja PC","Con luceS LED RGB",4,1, 59.96);
        Pedido pedido5 = new Pedido("1234E","Teclado USB","Color negro",5,1, 6.99);

        ArrayList<Pedido> listaClientes = new ArrayList<>();
        listaClientes.add(pedido1);
        listaClientes.add(pedido2);
        listaClientes.add(pedido3);
        listaClientes.add(pedido4);
        listaClientes.add(pedido5);

        String leer;

        try {

            // BufferedReader para recibir datos del padre


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();


            leer = br.readLine();

            for (Pedido item: listaClientes) {

                if(leer.equalsIgnoreCase(item.getDni())){
                    System.out.println("Mostrando pedido del cliente con DNI " + leer + ": " + item.mostrarDatosPedidos());
                }
            }

            //System.out.println("Su palabra es " + leer +  " || Numero de caracteres: " + leer.length());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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



