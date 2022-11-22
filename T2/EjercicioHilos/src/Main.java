import java.io.IOException;

public class Main extends Thread{

    private Padre padre;

    public Main(Padre padre){
        this.padre = padre;
    }

    public void correr(){
        try {
            System.out.println("----Iniciando...----");
            Thread.sleep(100);
            ProcessBuilder padre1 = new ProcessBuilder("java","src/Padre.java");
            padre1.inheritIO();
            Process process = padre1.start();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        correr();
    }

    public static void main(String[] args) {
        Main main1 = new Main(new Padre("ola"));
        main1.start();
    }
}

