package com.cloud.xue.other;

/**
 * @version: v1.0.0
 * Created by xuexiao on 2018-07-09 20:54:01.
 */
public class DecreaseThread extends Thread{
    private Sample sample;
    public DecreaseThread(Sample sample){
        this.sample = sample;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            try {
                Thread.sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sample.decrease();
        }
    }
}
