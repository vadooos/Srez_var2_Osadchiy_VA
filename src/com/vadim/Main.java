package com.vadim;

public class Main {

    public static volatile boolean allow = true;
    public static void main(String[] args) {

        NumCollection numCollection = new NumCollection();
        int[] mas = new int[100];
        new ThreadNumGenerator(mas, numCollection);
        new ThreadStatistics(mas, numCollection);
    }
}
