package com.vadim;

import java.util.Random;

/**
 * Created by vadim on 12.04.2017.
 */
public class ThreadNumGenerator implements Runnable{
    private Thread t = new Thread(this);
    Random rnd = new Random();
    int[] mas;
    NumCollection collection;

    public ThreadNumGenerator(int[] mas, NumCollection collection) {
        this.mas = mas;
        this.collection = collection;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (Main.allow){
                Thread.sleep(1000);
                synchronized (mas){
                    int i = rnd.nextInt(100);
                    mas[i] +=1;
                    if (mas[i] >= 5)
                        Main.allow = false;
                    mas.notifyAll();
                }

            }
            synchronized (mas){
                notifyAll();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
