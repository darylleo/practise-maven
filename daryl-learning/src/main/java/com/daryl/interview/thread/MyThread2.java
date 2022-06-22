package com.daryl.interview.thread;

/**
 * @author wl
 * @create 2022-01-20
 */
public class MyThread2 extends Thread {
    public static volatile boolean flag = false;


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(flag);
    }

}
