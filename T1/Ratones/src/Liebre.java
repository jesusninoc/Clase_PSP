public class Liebre extends Thread{

    private String nombre;
    private int tiempoCorrer;

    public Liebre(){}

    public Liebre(String nombre, int tiempoCorrer) {
        this.nombre = nombre;
        this.tiempoCorrer = tiempoCorrer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoCorrer() {
        return tiempoCorrer;
    }

    public void setTiempoCorrer(int tiempoCorrer) {
        this.tiempoCorrer = tiempoCorrer;
    }

    @Override
    public void run() {
        correr();
    }

    public void correr(){
        try{
            System.out.println("La liebre " + nombre + " empieza a correr");
            Thread.sleep(tiempoCorrer*1000);
            System.out.println("La liebre " + nombre + " ha terminado de correr");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
