public class Tortuga2 extends Thread{

    public void run() {
        int i = 0;
        System.out.println("Comienza la tortuga");

        while (i<5){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

        System.out.println("Acabo la tortuga");
    }

}
