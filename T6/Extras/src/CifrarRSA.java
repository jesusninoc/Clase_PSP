import javax.crypto.*;
import java.security.*;
public class CifrarRSA {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
            KeyPair keypair = keygen.generateKeyPair();

            Cipher rsaCipher = Cipher.getInstance("RSA");

            String mensaje = "Mensajeo";

            rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
            byte[] mensajeCifrado = rsaCipher.doFinal(mensaje.getBytes("UTF8"));
            System.out.println(mensajeCifrado);

            rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPublic());
            byte[] mensajeDescifrado = rsaCipher.doFinal(mensajeCifrado);
            String mensajeDescifrado2 = new String(mensajeDescifrado, "UTF8");
            System.out.println(mensajeDescifrado2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}