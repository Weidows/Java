package prodsmile.coding.java8plus;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        var future = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            //Thread.sleep(1000);
            // future.complete("Hello");

            future.completeOnTimeout("Hello", 1000, TimeUnit.MILLISECONDS);
            return null;
        });
        // sync. method blocking...
        var value = future.get();
        System.out.println(value);

    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        var successFuture = CompletableFuture.completedFuture("Hello");
        var failFuture = CompletableFuture.failedFuture(new InterruptedException());

        System.out.println(successFuture.get());

        if(failFuture.isCompletedExceptionally()) {
            System.out.println("error"); // print
        }
        System.out.println(failFuture.get()); // Exception
    }

}
