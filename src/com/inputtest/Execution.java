package com.inputtest;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Execution {

    public static void main(String[] args) {
        GradesMap GradesMapInstance;
        int numberstudents = 10;
        ExecutorService execute = Executors.newFixedThreadPool(2);
        Scanner input = new Scanner(System.in);
        String student = new String();
        String[] studentvals;
        for(int i =0; i<numberstudents; i++){
            student = input.nextLine();
            System.out.println("Student: " + student);
            studentvals = student.split(",");
            Runnable StudentAdd = new Parsers(studentvals[1],Integer.parseInt(studentvals[0]));
            execute.submit(StudentAdd);
        }

        GradesMap.getInstance().print();
        try {
            System.out.println("attempt to shutdown executor1");
            execute.shutdown();
            execute.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!execute.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            execute.shutdownNow();
            System.out.println("shutdown finished");
        }    }
}
