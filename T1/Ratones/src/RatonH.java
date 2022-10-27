public class RatonH extends Thread{

    private String nombre;
    private int tiempoAlimentacion;

    public RatonH(){}

    public RatonH(String nombre, int tiempoAlimentacion) {
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

    @Override
    public void run() {
        comer();
    }

    public static void main(String[] args) {
        RatonH raton1 = new RatonH("Pepito",4);
        RatonH raton2 = new RatonH("Lucas",5);
        RatonH raton3 = new RatonH("Carlos",6);

        raton1.start();
        raton2.start();
        raton3.start();
    }
}
