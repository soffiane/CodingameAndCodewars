package codingame; /**
 * C'est un code issu d'un test technique sur skillvalue pour alteca
 * test sur les fonctionnalités de Java 8 : ici les thread et executorservice
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThread implements Runnable {

    private static LocalTime NOW = LocalTime.now();
    private int offset;

    public WorkerThread(int offset) {
        this.offset = offset;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            NOW.plusHours(offset);
            System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(NOW));
        }
    }

    public static void main(String... args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i =0;i<10;i++){
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(100L);
                    LocalTime localTime = NOW.plusHours(finalI);
                    System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(localTime));
                } catch (InterruptedException e){
                    System.out.println("fin tache");
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
