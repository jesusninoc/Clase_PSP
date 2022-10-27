public class Carrera2 {

    public static void main(String[] args) {

        Tortuga2 tortuga = new Tortuga2();
        Thread liebre = new Thread(new Liebre2());

        tortuga.start();
        // INFORMACION SOBRE EL ESTADO DEL HILO
        System.out.println(tortuga.getState());
        liebre.start();
        System.out.println(liebre.getState());


    }
}