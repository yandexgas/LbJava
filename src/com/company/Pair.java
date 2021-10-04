package com.company;

public class Pair {
    public  Object first;
    public Object second;
    public Pair(){};
    public Pair(Object fst, Object scd){
        first=fst;
        second=scd;
    }
    public Pair(Pair p){
        first= p.first;
        second=p.second;
    }
}
