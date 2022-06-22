package com.daryl.interview.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wl
 * @create 2022-01-19
 */
public class MyThread implements Runnable {

    int num = 100;

    int count = 0;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //synchronized (this){
//            lock.lock();
//                if (num<1){
//                    break;
//                }
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();
            try {
                if (num < 1) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "售出第----->" + num + "---张票了！");
                num--;
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
            //没有加上  try... catch ... finally  会一直在跑
            finally {
                lock.unlock();
            }
        }
        //}
        System.out.println(count);
    }
}
