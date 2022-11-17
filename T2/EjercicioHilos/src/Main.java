public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(1,"1234A","Angelica","Fernandez",21,600111222,"angelicafernandez@gmail.com", new int[] { 3, 4, 7, 1, 2}); // total seg = 17
        Cliente cliente2 = new Cliente(2,"1234B","Raul","Alvarez",34,600111333,"raulalvarez@gmail.com", new int[] { 1, 5, 3 }); // total seg: 9 -> supuesto total estimado: 26seg

        // Establecer un tiempo inicial de referencia para supervisar la duracion de los procesos
        long tiempoInicial = System.currentTimeMillis();

        Gestoria gestoria = new Gestoria("Riu S.A", cliente1, tiempoInicial);
        Gestoria gestoria1 = new Gestoria("Riu S.A", cliente2, tiempoInicial);

        gestoria.start();
        gestoria1.start();
    }
}
