import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
import java.nio.file.*;

public class UDPClient {
    public static void main(String[] args) {
        String filePath = "src/SampleSyslogs.txt";
        String host = "localhost";

        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(host);

            while (true){
                byte[] buffer = Files.readAllBytes(Paths.get(filePath));

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip , 1234);
                socket.send(packet);

                System.out.println("File sent" + buffer.length);
                Thread.sleep(7000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
