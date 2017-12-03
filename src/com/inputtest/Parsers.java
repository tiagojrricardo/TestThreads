package com.inputtest;

public class Parsers implements Runnable {
    private String name;
    private int number;

    @Override
    public void run() {
        GradesMap.getInstance().putStudent(this.number,this.name);

    }

    public Parsers(String name, int number){
        setName(name);
        setNumber(number);
    }
    public void setName(String name){
        this.name=name;
    }

    public void setNumber(int number){
        this.number=number;
    }


}
