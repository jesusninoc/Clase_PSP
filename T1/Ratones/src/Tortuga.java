public class Tortuga extends Thread {

    private String nombre;
    private int tiempoCorrer;

    public Tortuga(){}

    public Tortuga(String nombre, int tiempoCorrer) {
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
            System.out.println("La tortuga " + nombre + " empieza a correr");
            Thread.sleep(tiempoCorrer*2000);
            System.out.println("La tortuga " + nombre + " ha terminado de correr");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Liebre liebre = new Liebre("Bugs Bunny", 3);
        Tortuga tortuga = new Tortuga("Paco",3);

        liebre.start();
        tortuga.start();
    }
}
