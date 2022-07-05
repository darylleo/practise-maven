package com.daryl.practice.interview.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 理解 线程的 suspend() resume() stop() ---->
 *  这些方法均已被标注过时
 *
 * @author wl
 * @create 2022-03-21
 */
public class ThreadTest02 {

    public static void main(String[] args) throws Exception{
        Thread myThread = new Thread(new MyThread());
        //开启线程
        System.out.println("线程开启");
        myThread.start();
        TimeUnit.SECONDS.sleep(3);

        //暂停线程
        /**
         * 当调用suspend时，线程不会将当前持有的资源释放（如锁），而是占有者资源进入暂停状态。容易造成死锁。
         */
        System.out.println("暂停线程");
        myThread.suspend();
        TimeUnit.SECONDS.sleep(3);

        //恢复线程
        System.out.println("线程恢复");
        myThread.resume();
        TimeUnit.SECONDS.sleep(3);

        //终止线程
        /**
         * 当调用stop时，会立即停止run中剩余的操作。可能会导致一些工作得不到完成，如文件流，数据库等关闭。并且
         * 会立即释放该线程所持有的所有的锁，导致数据得不到同步的处理，出现数据不一致问题
         */
        System.out.println("线程终止");
        myThread.stop();
        //TimeUnit.SECONDS.sleep();
    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Thread.currentThread().setName("MyThread");
            while (true){
                System.out.println(Thread.currentThread().getName() + "run at"+ dateFormat.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
