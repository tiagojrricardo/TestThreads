package com.testthreads1;

import java.util.concurrent.*;

public class Execute1 {

    public static void main(String[] args) {
       ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i=0; i<10; i++){
            Runnable worker = new WorkerThread1(""+ i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");



        // Example with Threads - a vector is required - see testthreads2
        // Runnable worker = new WorkerThread1(""+ 1);
        //Thread thread = new Thread(worker);
        //thread.start();

    }
}
