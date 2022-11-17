public class Main {

    public static void main(String[] args) {

        /*
        // Implementar el llamado de clientes desde el padre al hijo
        Cliente cliente1 = new Cliente(1,"1234A","Angelica","Fernandez",21,600111222,"angelicafernandez@gmail.com", new int[] { 2, 1, 2, 1, 2}); // total seg = 8
        Cliente cliente2 = new Cliente(2,"1234B","Raul","Alvarez",34,600111333,"raulalvarez@gmail.com", new int[] { 1, 2, 3 }); // total seg: 6 -> supuesto total estimado: 14seg

        // Establecer un tiempo inicial de referencia para supervisar la duracion de los procesos
        long tiempoInicial = System.currentTimeMillis();

        Gestoria gestoria = new Gestoria("Riu S.A", cliente1, tiempoInicial);
        Gestoria gestoria1 = new Gestoria("Riu S.A", cliente2, tiempoInicial);

        gestoria.start();
        gestoria1.start();
        */

        Hijo3 hilo = new Hijo3("Juan");
        hilo.start();
    }
}
