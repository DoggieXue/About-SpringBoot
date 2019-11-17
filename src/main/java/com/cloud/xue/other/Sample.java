package com.cloud.xue.other;

public class Sample {
    private int number;

    public synchronized void increase(){
        if (number != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number++;
        System.out.println(number);
        notify();
    }

    public synchronized void decrease(){
        if(number == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        number--;
        System.out.println(number);
        notify();
    }
}
