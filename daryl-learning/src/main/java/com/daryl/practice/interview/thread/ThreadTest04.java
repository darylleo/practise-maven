package com.daryl.practice.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * wait notify--> 生产者消费者模型
 *
 * @author wl
 * @create 2022-03-21
 */
public class ThreadTest04 {
    private static final Object lock = new Object();

    private static boolean flag = false;

    public static void main(String[] args) throws Exception{
        new Thread(new Consumer(),"consumer").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Producer(),"producer").start();
        System.out.println("");
    }

    static class Consumer implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (!flag){
                    //条件不满足，进入等待
                    System.out.println(Thread.currentThread().getName()+"-->"+"flag is false");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足，退出等待
                System.out.println(Thread.currentThread().getName()+"-->"+"flag is true");
            }
        }
    }

    static class Producer implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"--->"+"hold lock");
                lock.notify();
                flag = true;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
