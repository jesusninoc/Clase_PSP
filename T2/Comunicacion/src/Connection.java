import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    public static void main(String[] args) {

        // Muestra por consola la informacion de la pagina web (URL)

        try {
            URL url = new URL("https://www.jesusninoc.com/");
            String inputLine;
            URLConnection hc = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(hc.getInputStream()));

            while((inputLine = br.readLine()) != null){
                System.out.println(inputLine);
            }

            br.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
