import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Multicast {
    public static void main(String args[])
    {
        try
        {
            int port = 2020;
            //224.0.0.1 ... 224.0.0.255
            InetAddress multicastGroupIP = InetAddress.getByName("224.0.0.5");
            System.out.println(multicastGroupIP);
            MulticastSocket socket = new MulticastSocket(port);

            socket.joinGroup(multicastGroupIP);

            byte[] m = "hi".getBytes();
            DatagramPacket send = new DatagramPacket(m, m.length, multicastGroupIP, port);
            socket.send(send);

            byte[] bufer = new byte[1000];
            String linea;

            while (true)
            {
                DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
                socket.receive(receive);
                linea = new String(receive.getData(), 0, receive.getLength());
                System.out.println("Receive: " + linea);

                //Break if "Bye"
                if (linea.equals("Bye"))
                {
                    socket.close();
                    break;
                }
            }
            socket.leaveGroup(multicastGroupIP);
        }
        catch (SocketException e) {}
        catch (IOException e) {}
    }
}