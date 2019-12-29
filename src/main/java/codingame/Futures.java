/**
 * Un code issu d'un test technique en ligne
 * Aborde une notion de java 8 : les futures
 * A Future represents the result of an asynchronous computation.
 * Methods are provided to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation.
 * The result can only be retrieved using method get when the computation has completed, blocking if necessary until it is ready.
 * Cancellation is performed by the cancel method. Additional methods are provided to determine if the task completed normally or was cancelled.
 * Once a computation has completed, the computation cannot be cancelled.
 * If you would like to use a Future for the sake of cancellability but not provide a usable result, you can declare types of the form Future<?> and return null as a result of the underlying task.
 */

package codingame;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Futures {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = new Random().ints(5000000,0,9)
                .boxed().collect(Collectors.toList());
        CompletableFuture<Long> countZeros = CompletableFuture.supplyAsync(() -> numbers.stream().filter(integer -> integer == 0).count());

        CompletableFuture<Long> countOnes = CompletableFuture.supplyAsync(() -> numbers.stream().filter(integer -> integer == 1).count());
        countZeros.thenCombine(countOnes, Long::sum).thenAccept(System.out::println).get();
    }
}
