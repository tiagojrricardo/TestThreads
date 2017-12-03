package com.testthreads4;

import java.util.concurrent.*;

public class Execute4 {


    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futexec = executor.submit(task);

        System.out.println("future done? " + futexec.isDone());

        //Calling the method get() blocks the current thread and waits until the callable completes.

        Integer result = null;
        try {
            result = futexec.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + futexec.isDone());
        System.out.print("result: " + result);

        executor.shutdownNow();


        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        Future<Integer> futurexec1 = executor1.submit(() ->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return 456;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            //Wait timeout
            Integer result1 = futurexec1.get(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        executor1.shutdownNow();
        //In order to schedule tasks to be executed periodically, executors provide the two methods scheduleAtFixedRate() and scheduleWithFixedDelay().
        // The first method is capable of executing tasks with a fixed time rate. - doesn't take into account the actual duration of the task.
        //In that case you should consider using scheduleWithFixedDelay() instead. This method works just like the counterpart described above.
        // The difference is that the wait time period applies between the end of a task and the start of the next task.
        /*ScheduledExecutorService execexample = Executors.newScheduledThreadPool(1);
        int initialDelay = 0;
        int period = 1;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
        */
    }
}
