import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ProCon pc = new ProCon(5);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0 ; i < 10 ; i++){
            final int j = i;
            executor.submit(()->{
                try{
                    pc.enqueue(j);
                    System.out.println("Enqueued " + j );
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0 ; i < 10 ; i ++){
            executor.submit(()->{
                try{
                    System.out.println("Dequeued " + pc.dequeue());
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}


