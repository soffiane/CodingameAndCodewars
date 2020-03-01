package codingame; /**
 * C'est un code issu d'un test technique sur skillvalue pour alteca
 * test sur les fonctionnalités de Java 8 : ici les acces concurrents et les threads (executorservice)
 */

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class TestAccumulator {
    public static void main(String... args){
        LongAccumulator accumulator = new LongAccumulator(Long::sum,0);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Arrays.stream(new int[] {1,2,3,4,5,6,7,8,9})
                .forEach(value -> executorService.execute(() -> accumulator.accumulate(value)));
        executorService.shutdown();
        while(!executorService.isTerminated()) {}
        System.out.println(accumulator.getThenReset());
        System.out.println(accumulator.get());
    }
}
