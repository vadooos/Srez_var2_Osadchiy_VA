package com.vadim;

/**
 * Created by vadim on 12.04.2017.
 */
public class ThreadStatistics implements Runnable{
    int[] mas;
    NumCollection collection;
    Thread t = new Thread(this);

    public ThreadStatistics(int[] mas, NumCollection collection) {
        this.collection = collection;
        this.mas = mas;
        t.start();
    }

    @Override
    public void run() {
        try {
            while (Main.allow){
                Thread.sleep(5000);
                synchronized (mas) {
                    mas.wait();
                    for (int i = 0; i < 100; i++) {
                        if (mas[i] > 0)
                            System.out.printf("%d: (%d);   ", i, mas[i]);
                    }
                    System.out.println();
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
