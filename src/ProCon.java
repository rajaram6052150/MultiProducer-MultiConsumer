import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class ProCon {

    public Semaphore full , empty;
    public ConcurrentLinkedDeque<Integer> deque;

    public ProCon(int size) {
        deque = new ConcurrentLinkedDeque<>();
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    public void enqueue(int x) throws InterruptedException {
        empty.acquire();
        deque.addFirst(x);
        full.release();
    }

    public int dequeue() throws InterruptedException {
        full.acquire();
        int resut = deque.pollLast();
        empty.release();
        return resut;
    }
}


