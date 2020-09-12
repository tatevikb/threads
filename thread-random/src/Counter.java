import java.util.Random;

public class Counter implements Runnable {
    private static int count = 0;
    private int id;

    public Counter(int id)
    {
        this.id = id;
    }

    @Override
    public void run()
    {
        try {
            int ms = new Random().nextInt(6) + 5;
            Thread.sleep(ms * 1000);
            synchronized (this) {
                ++count;
            }
            System.out.printf("Thread %d slept %d, count = %d%n", id, ms, count);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
