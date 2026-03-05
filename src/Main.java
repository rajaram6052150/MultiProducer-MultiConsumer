import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args)  {

        ProCon pc = new ProCon(5);
        Logger logger = Logger.getLogger(Main.class.getName());
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                while (true) {
                    try {
                        String log = pc.dequeue();
                        System.out.println("Consumed: " + log);

                        Thread.sleep(100);

                    } catch (Exception e) {
                        logger.info("Consumer failed");
                    }
                }
            });
        }

        try{
            DatagramSocket socket = new DatagramSocket(1234);
            byte[] buffer = new byte[65535];

            while (true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData() , 0 , packet.getLength());

                String[] lines = message.split("\n");

                for (String line : lines){
                    executor.submit(()->{
                        try{
                           pc.enqueue(line);
                           System.out.println("Produced " + line);
                       }
                       catch(Exception e){
                           logger.info("enqueue Failed");
                       }
                    });
                }
            }
        }

        catch(Exception e){
            logger.severe("Error listening " + e.getMessage());
        }
        executor.shutdown();
    }
}




