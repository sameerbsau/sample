package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {


    public static void main(String[] args) {
        Executor e = Executors.newCachedThreadPool();
        e.execute(new MyThread());
        ThreadPoolExecutor pool = (ThreadPoolExecutor) e;
        pool.shutdown();
    }
    static class MyThread implements Runnable{

        @Override
        public void run() {
            Long duration = (long) (Math.random() * 5);
            System.out.println("Running Thread!");
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread Completed");
        }
    }
}