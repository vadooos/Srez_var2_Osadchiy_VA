package com.vadim;

import java.util.Random;

/**
 * Created by vadim on 12.04.2017.
 */
public class ThreadNumGenerator implements Runnable{
    private Thread t = new Thread(this);
    private Random rnd = new Random();
    private int[] mas;

    public ThreadNumGenerator(int[] mas) {
        this.mas = mas;
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
                    Main.count ++;
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
