import java.util.ArrayList;

public class Gestoria extends Thread{

    private String nombre;
    private Cliente cliente;
    private ArrayList<Cliente> listaClientes;
    private long tiempoInicial;

    public Gestoria(String nombre, Cliente cliente, long tiempoInicial) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoInicial = tiempoInicial;
        this.listaClientes = new ArrayList<Cliente>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public long getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(long tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
    }

    @Override
    public void run() {

        // Aniadimos a los clientes para posteriormente, realizar los tramites de cada uno
        listaClientes.add(cliente);
        System.out.println("Lista de clientes: ");
        mostrarClientes();

        // Mensaje de explicacion
        System.out.println("La gestoría " + this.nombre + " empieza a realizar los tramites del cliente "
                            + this.cliente.getNombre() + " " + this.cliente.getApellido()  + ", con DNI: "
                            + this.cliente.getDni() + " en el tiempo: " + (System.currentTimeMillis() - this.tiempoInicial) / 1000
                            + "seg"
        );

        System.out.println("");

        // Inicio de recorrer los tramites
        for(int i = 0; i < this.cliente.getTramites().length; i++){
            this.esperarXSegundos(cliente.getTramites()[i]);
            System.out.println("Procesando el tramite " + (i+1)
                    + " del cliente " + this.cliente.getNombre() + " " + this.cliente.getApellido() + " " + ", con DNI: "
                    + this.cliente.getDni() + " -> Tiempo: "
                    + (System.currentTimeMillis() - this.tiempoInicial) / 1000
                    + "seg"
            );
        }

        // Resultado
        System.out.println("        -> La gestoría " + this.nombre + " ha realizado exitosamente los tramites del cliente "
                    + this.cliente.getNombre() + " " + this.cliente.getApellido() + ", con DNI: "
                    + this.cliente.getDni() + " en el tiempo: "
                    + (System.currentTimeMillis() - this.tiempoInicial) / 1000
                    + "seg"
        );
    }

    // Metodo que hara que cada tramite se trate como si fuese el tiempo de duracion que tarda en realizarse
    private void esperarXSegundos(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarClientes(){
        for (Cliente item : listaClientes) {
            System.out.println(item.mostrarDatos());
        }
    }
}
