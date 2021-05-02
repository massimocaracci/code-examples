package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture.runAsync
 * The ‘runAsync’ method can be used to spawn a new thread and run code asynchronously, whilst accepting a ‘Runnable’ instance as a parameter.
 * It doesn't return any result and so instead returns a ‘CompletableFuture<Void>’.
 * Overall, this method should be used when the thread doesn't return any value, with the following code demonstrating how this works
 */
public class CompletableFutureRunAsyncJava8 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Here, a new ‘Runnable’ instance is created and implemented via a lambda expression.
        Runnable runnable = () -> System.out.println("Threading saying Hello");

        //The ‘CompletableFuture.runAsync’ method is invoked using the ‘Runnable instance’, which spawns a new Thread and executes the ‘Sysout’ statement. When this code is executed, it'll print the following output:
        System.out.println("Starting new Thread from Main");
        CompletableFuture<Void> cFuture = CompletableFuture.runAsync(runnable);

        System.out.println("Main Doing something else");
        System.out.println("Main completed");
    }
}
