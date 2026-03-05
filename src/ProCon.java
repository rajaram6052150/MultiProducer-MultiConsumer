import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProCon {

    public BlockingQueue<String>  queue;

    public ProCon(int size) {
        queue = new LinkedBlockingQueue<>(size);
    }

    public void enqueue(String x) throws InterruptedException {
        queue.put(x);
    }

    public String dequeue() throws InterruptedException {
        return queue.take();
    }
}
