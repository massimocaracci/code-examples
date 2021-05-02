package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable and Future: Common Disadvantages of Future
 * Although the ‘Future’ interface enables you to return a result from a Thread, it has several disadvantages including:
 * The 'get' method in the 'Future' interface is blocking, so if the result of computation is complete, it returns immediately.
 * Otherwise, it'll wait till the computation is completed.
 * If you want to perform some actions on the result of the computation, you'll need to wait till the result is available.
 * <p>
 * ·There's no way to manually complete the task. So if the task is hung, there is no way of manually marking it as complete.
 * ·Multiple 'Futures' cannot be chained or combined.
 * ·   The 'Future' interface does not support any exception handling mechanism.
 * To solve all these issues, the ‘CompletableFuture’ class was introduced by Java 8.
 */
public class CallableFutureJava5 {

    public static void main(String[] args) throws Exception {

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(1000);
            return "Hello";
        };

        System.out.println("Starting new Thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        System.out.println("Doing something else");

        System.out.println("Retrieve thread result");
        String result = future.get(); // this blocks till result is available
        System.out.println("Result is:" + result);
        executorService.shutdown();
    }
}
