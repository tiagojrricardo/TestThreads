package com.testthreads3;

import java.util.concurrent.*;

public class WorkerThread3 implements Runnable {
    @Override
    public void run(){
        try {
            String name = Thread.currentThread().getName();
            System.out.println("Foo " + name);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Bar " + name);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
