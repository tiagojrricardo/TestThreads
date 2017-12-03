package com.testthreads2;

public class Execute2 {

    public static void main(String[] args) {
        WorkerThread2[] wtvect = new WorkerThread2[10];
        for(int i=0; i<10; i++){
            wtvect[i]=new WorkerThread2(""+ i);
            wtvect[i].start();
        }
        for(WorkerThread2 wt: wtvect){
            while(wt.isAlive()){
            }
        }
        wtvect=null;
    }
}
