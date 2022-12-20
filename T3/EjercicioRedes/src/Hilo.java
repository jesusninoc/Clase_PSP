import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo extends Thread{

    private Socket cliente = null;
    String url;

    public Hilo(Socket param){
        this.cliente = param;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(cliente.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String inputline = in.readLine();

            System.out.println("recibido: " + inputline);
            System.out.println("Generando url.............");
            url = "https://randomuser.me/api/?results=" + inputline.toString();

            // envio de la url
            out.println("Su url con los datos de las personas es la siguiente: " + url);
            out.close();
            in.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}