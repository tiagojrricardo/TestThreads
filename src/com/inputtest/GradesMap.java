package com.inputtest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GradesMap {
    private HashMap<Integer,String> Students;
    //private ConcurrentMap<Integer,Integer> Grades;
    private static GradesMap GradesInstance;

    private GradesMap(){

    }

    public static GradesMap getInstance(){
        if(GradesInstance==null){
           GradesInstance = set();
        }
            return GradesInstance;
        }


    public static GradesMap set(){
        GradesMap newInstance = new GradesMap();
        //newInstance.Grades = new ConcurrentHashMap<Integer, Integer>();
        newInstance.Students = new HashMap<Integer,String>();
        return newInstance;
    }

    public synchronized void putStudent(int number, String name){
        this.Students.put(number,name);
    }

    public void print(){
        for(HashMap.Entry<Integer,String> entry: Students.entrySet()){
            System.out.println(entry);
        }
    }
}
