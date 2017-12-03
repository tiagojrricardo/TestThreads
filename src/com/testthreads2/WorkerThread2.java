package com.testthreads2;

public class WorkerThread2 extends Thread {

    public String command;
    public WorkerThread2(String s){
        this.command=s;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }

}
