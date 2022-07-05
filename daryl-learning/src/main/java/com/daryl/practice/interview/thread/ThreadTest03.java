package com.daryl.practice.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * interrupt()-->安全且优雅的线程中断
 *  注意：处于死锁下的线程，无法被中断
 *
 * @author wl
 * @create 2022-03-21
 */
public class ThreadTest03 {

    public static void main(String[] args) throws Exception {
        Thread myThread = new Thread(new MyThread(), "myThread");
        myThread.start();
        TimeUnit.SECONDS.sleep(3);
        myThread.interrupt();
    }

    //run 和  start 的区别： run 方法是实现线程执行的业务逻辑，而start方法则是开启一个新的线程
    private static class MyThread implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println(Thread.interrupted()+"-->"+"Thread");
                System.out.println(Thread.currentThread().isInterrupted()+"-->"+"Thread.currentThread");
                System.out.println(Thread.currentThread().getName() + "\t" + "is  running");
            }
            System.out.println(Thread.interrupted()+"-->"+"Thread");
            System.out.println(Thread.currentThread().isInterrupted()+"-->"+"Thread.currentThread");
        }
    }
}
