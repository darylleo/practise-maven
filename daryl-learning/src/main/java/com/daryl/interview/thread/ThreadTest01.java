package com.daryl.interview.thread;

import java.util.concurrent.Callable;

/**
 * 线程实现测试
 *
 * @author wl
 * @create 2022-03-21
 */
public class ThreadTest01 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new UseThread().start();
        new Thread(new UseRunnable()).start();
        new Thread(() -> System.out.println(333)).start();
        //new Thread(new useCallable()).start();
    }

    private static class UseThread extends Thread {

        @Override
        public void run() {
            Thread.currentThread().setName("useThread");
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            Thread.currentThread().setName("useRunnable");
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class useCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "call";
        }
    }
}
