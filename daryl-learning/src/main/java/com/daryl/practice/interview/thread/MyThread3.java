package com.daryl.practice.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wl
 * @create 2022-01-20
 */
public class MyThread3 extends Thread{
    public static  int  a = 0;
    static AtomicInteger at = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 200000; i++) {
            a++;
            //at.getAndIncrement();
        }
        System.out.println("finish" +"==>"+ a);
        //System.out.println("finish" +"==>"+ at.get());
    }
}
