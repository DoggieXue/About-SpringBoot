package com.cloud.xue.other;

public class ThreadTest {
    public static void main(String[] args) {
        Runnable r = new HelloThread();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}

class HelloThread implements Runnable{
    int i;
    @Override
    public void run() {
        i = 0;
        while(true){
            System.out.println("number: " + i++);
            try {
                Thread.sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 50){
                break;
            }
        }
    }
}
