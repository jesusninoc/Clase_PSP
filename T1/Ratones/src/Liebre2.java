public class Liebre2 implements Runnable{

    @Override
    public void run() {
        int i = 0;
        System.out.println("Comienza la liebre");

        while (i<5){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }

        System.out.println("Acabo la liebre");
    }
}
