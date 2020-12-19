import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThreadPool implements Executor {

    private final Queue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private volatile boolean isRunnable = true;

    public ThreadPool(int countThreads) {
        for (int i = 0; i < countThreads; i++) {
            new Thread(new Task()).start();
        }
    }

    @Override
    public void execute(Runnable command) {
        if (isRunnable) {
            queue.offer(command);
        }
    }

    public void shutdown() {
        isRunnable = false;
    }

    private final class Task implements Runnable {

        @Override
        public void run() {
            while (isRunnable) {
                Runnable task = queue.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}
