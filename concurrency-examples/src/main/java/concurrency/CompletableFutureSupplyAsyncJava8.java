package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * The ‘supplyAsync’ method is similar to the ‘runAsync’ method and can be used to spawn a new Thread and run code at the same time,
 * with the only difference being that it can be used to return a value from the Thread.
 * Accepting a ‘Supplier’ instance as a parameter, this works to supply the return value and returns a ‘CompletableFuture<T>’
 * that corresponds to the return value which is produced by the ‘Supplier’ instance.
 */
public class CompletableFutureSupplyAsyncJava8 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Supplier<String> supplier = () -> "hello";
        System.out.println("Starting new Thread from main");
        CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Main Doing something else");
        System.out.println("Blocking and retrieving result in Main");
        String result = cFuture.get();
        System.out.println("Result is " + result);
        System.out.println("Main thread completed");
    }
}
