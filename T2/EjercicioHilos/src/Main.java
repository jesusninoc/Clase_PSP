public class Main {

    public static void main(String[] args) {
        Proceso1 hilo1 = new Proceso1();
        Proceso2 hilo2 = new Proceso2();
        Proceso3 hilo3 = new Proceso3();
        Proceso4 hilo4 = new Proceso4();

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
