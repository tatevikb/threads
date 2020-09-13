import java.util.Random;

public class Counter implements Runnable {
    private static int count = 0;
    private static boolean stopAll = false;
    private int id;

    public Counter(int id)
    {
        this.id = id;
    }

    public static synchronized void stop()
    {
        stopAll = true;
    }

    public synchronized int increment() {
        return count++;
    }

    @Override
    public void run()
    {
        try {
            int ms = new Random().nextInt(6) + 5;
            while( !stopAll ) {
                Thread.sleep(ms * 1000);
                increment();
                System.out.printf("Thread %d slept %d, count = %d%n", id, ms, count);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
