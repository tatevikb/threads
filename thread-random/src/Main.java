import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        {
            int threadNum = Integer.parseInt(args[0]);
            ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
            for (int i = 0; i < threadNum; i++) {
                executorService.submit(new Counter(i));
            }
            Thread.sleep(60 * 1000);
            Counter.stop();
            executorService.shutdown();
        }
    }
}
