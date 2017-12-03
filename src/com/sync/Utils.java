package com.sync;

public class Utils implements Runnable{
    int count = 0;
    int countsync = 0;
    void increment() {
        this.count = this.count + 1;
    }
    synchronized void incrementSync() {
        this.countsync = this.countsync + 1;
    }

    /*

    ReentrantLock lock = new ReentrantLock();
int count = 0;

void increment() {
    lock.lock();
    try {
        count++;
    } finally {
        lock.unlock();
    }
}


     */
    @Override
    public void run(){
        this.increment();
        this.incrementSync();
    }

    @Override
    public String toString(){
        return String.valueOf(count + " / " + countsync);
    }
}
