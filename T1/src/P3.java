import java.io.IOException;

public class P3 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C",
                "\"C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.1\\jbr\\bin\\java.exe\" P2 -cp " +
                        "C:\\Users\\Usuario DAM2\\Documents\\GitHub\\ClasePSP\\T1\\src\\P3.java");
        pb.start();
    }
}
