package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {
    public static void main(String[] args) {
        try {
            Future<String> completableFuture = calculateAsync();
            String result = completableFuture.get();

            System.out.println(result);
            //if we know the result use the completedFuture

            CompletableFuture<String> future = CompletableFuture.completedFuture("helllo");
            result = future.get();
            System.out.println(result);

            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hiiii");
            System.out.println(future1.get());

            CompletableFuture<String> future2 = future1.thenApply(s -> s+"sameer");
            System.out.println(future2.get());

            CompletableFuture<Void> future3 = future1.thenAccept(s -> System.out.println("final result"+ s));
            System.out.println(future3.get());

            CompletableFuture<Void> future4 = future1.thenRun(() -> System.out.println("completed"));
            System.out.println(future4.get());

            CompletableFuture<String> future5 = future.thenCompose(s -> CompletableFuture.supplyAsync(()-> s+" world"));
            System.out.println(future5.get());

            CompletableFuture<String> completableFuture1
                    = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenCombine(CompletableFuture.supplyAsync(
                            () -> " World"), (s1, s2) -> s1 + s2);

            CompletableFuture future6 = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                            (s1, s2) -> System.out.println(s1 + s2));

            System.out.println(completableFuture1.get());


            CompletableFuture<Void> combinedFuture
                    = CompletableFuture.allOf(future1, future2, future3);
            System.out.println(combinedFuture.get());

            String combined = Stream.of(future1, future2, future5)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(""));
            System.out.println(combined);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("hello");
            return null;
        });

        return completableFuture;
    }
}