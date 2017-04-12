package com.vadim;

/**
 * Created by vadim on 12.04.2017.
 */
public class NumCollection {
    private int[] mas = new int[100];

    public synchronized void pushNum(int n){
        mas[n] += 1;

    }

    public  int get(int i){
        return mas[i];
    }

}
