package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * The ‘runAsync’ and ‘supplyAsync’ methods demonstrated above get a Thread from the ‘ForkJoinPool.commonPool’ (which is a global Thread pool).
 * It’s key to remember that there are overloaded versions of these methods that accept an ‘Executor’ instance and obtain Threads from the passed executor.
 * The code below shows how this works:
 */
public class CompletableFutureSupplyAsyncExecutorJava8 {

    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Threading saying Hello");
        System.out.println("Starting new Thread from Main");

        //Here, in addition to the ‘Runnable’ instance, the ‘runAsync’ method accepts an argument as the ‘Executor’ instance, meaning that ‘Runnable’ is executed by the ‘Executor’ passed in.
        // Similarly, there’s also an overloaded version of the ‘supplyAsync’ method that accepts an Executor instance overall.
        CompletableFuture<Void> cFuture = CompletableFuture.runAsync(
                runnable,
                Executors.newSingleThreadExecutor());
        System.out.println("Main Doing something else");
        System.out.println("Main completed");
    }
}
