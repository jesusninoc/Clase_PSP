import java.util.Base64;

public class Base642 {
    public static void main(String args[]){
        String entradaOriginal = "Texto";
        String cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());

        System.out.println("Codificado: " + cadenaCodificada);

        byte[] bytesDecodificados = Base64.getDecoder().decode(cadenaCodificada);
        String cadenaDecodificada = new String(bytesDecodificados);

        System.out.println("Decodificado: " + cadenaDecodificada);
    }
}