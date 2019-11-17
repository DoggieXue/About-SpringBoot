package com.cloud.xue.other;

/**
 * @version: v1.0.0
 * Created by xuexiao on 2018-07-09 20:52:36.
 */
public class MainTest {
    public static void main(String[] args) {
        Sample sample = new Sample();
        Thread thread1 = new IncreaseThread(sample);
        Thread thread2 = new DecreaseThread(sample);

        thread1.start();
        thread2.start();
    }
}
