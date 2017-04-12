package com.vadim;

public class Main {

    public static volatile boolean allow = true;
    public static volatile int count = 0;
    private static int[] mas = new int[100];

    public static void main(String[] args) {
        new ThreadNumGenerator(mas);
        new ThreadStatistics(mas);
    }
}
