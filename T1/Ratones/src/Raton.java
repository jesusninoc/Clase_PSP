public class Raton {

    private String nombre;
    private int tiempoAlimentacion;

    public Raton(){}

    public Raton(String nombre, int tiempoAlimentacion) {
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }


    public void comer(){
        try{
            System.out.println("El raton " + nombre + " empieza a comer");
            Thread.sleep(tiempoAlimentacion*1000);
            System.out.println("El raton " + nombre + " ha terminado de zampar");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoAlimentacion() {
        return tiempoAlimentacion;
    }

    public void setTiempoAlimentacion(int tiempoAlimentacion) {
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public static void main(String[] args) {
        Raton raton1 = new Raton("Pepito",4);
        Raton raton2 = new Raton("Lucas",5);
        Raton raton3 = new Raton("Carlos",6);

        raton1.comer();
        raton2.comer();
        raton3.comer();
    }
}
