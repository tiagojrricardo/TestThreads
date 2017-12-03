package com.testthreads3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Execute3 {

    public static void main(String[] args) {
        Runnable worker = new WorkerThread3();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(worker);
        executor.shutdown();

        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        executor1.submit(worker);

        Runnable task = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor1.submit(task);

        try {
            System.out.println("attempt to shutdown executor1");
            executor1.shutdown();
            executor1.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor1.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor1.shutdownNow();
            System.out.println("shutdown finished");
        }

    }
}
