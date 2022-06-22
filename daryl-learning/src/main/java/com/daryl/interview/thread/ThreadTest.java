package com.daryl.interview.thread;

import jdk.nashorn.internal.ir.ForNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wl
 * @create 2022-01-19
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception {
        //test01();
        //test02();
        //test03();
        //Thread.sleep(3000);
//        for (int i = 0; i < 100000; i++) {
//            MyThread3.a++;
//            //MyThread3.at.getAndIncrement();
//        }

        //System.out.println("--------------------->" + MyThread3.at.get());
        //System.out.println("--------------------->" + MyThread3.a);
        //System.out.println(MyThread.class.getName());

        //copyOnWriteArrayListTest();

        //mapTest();

        //countDownLatchTest();

        //CyclicBarrierTest();

        //semaphoreTest();

        //exchangerTest();

        //threadPoolTest();

        //deadLockTest();
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t3");
            }
        });
        Thread.currentThread().join();
        t3.start();
        t2.start();
        t1.start();

    }

    /**
     * 主内存变量可见性测试
     */
    public static void test01() {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "窗口1");
        Thread thread2 = new Thread(myThread, "窗口2");
        Thread thread3 = new Thread(myThread, "窗口3");
        Thread thread4 = new Thread(myThread, "窗口4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public static void test02() {
        //new MyThread2().start();
        int count = 0;
        while (true) {
            //System.out.println(MyThread2.flag);
            count++;
            if (MyThread2.flag) {
                //System.out.println(count);//86w
                break;
            }
        }
    }

    public static void test03() {
        new MyThread3().start();
    }

    /**
     * arrayList 线程安全测试
     */
    public static void copyOnWriteArrayListTest() throws Exception {
        Thread thread = new Thread(new MyThread4());
        Thread thread1 = new Thread(new MyThread4());
        thread.start();
        thread1.start();
        //System.out.println(MyThread4.list.size());
        System.out.println(MyThread4.list2.size());
        MyThread4.list2.stream().sorted().forEach(System.out::println);
    }

    //copyOnWriteArrayListTest
    static class MyThread4 implements Runnable {

        static ArrayList<Integer> list = new ArrayList<>();

        static CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                //list.add(i);
                list2.add(i);
            }
            //System.out.println(list.size());
            System.out.println(list2.size());
            System.out.println("add finish!");
        }
    }

    /**
     * hashMap 多线程测试
     */
    public static void mapTest() throws Exception {
        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread5()).start();
        }
        TimeUnit.SECONDS.sleep(3);
        //System.out.println(MyThread5.hashMap.size());
        System.out.println(MyThread5.hashtable.size());
        // System.out.println(MyThread5.concurrentHashMap.size());
    }

    //map test
    static class MyThread5 extends Thread {

        static HashMap<Integer, Integer> hashMap = new HashMap<>();

        static Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //hashMap.put(i,i);
                hashtable.put(i, i);
                //concurrentHashMap.put(i,i);
            }
            System.out.println("put finish");
        }
    }

    /**
     * CountDownLatch test
     */
    @Test
    public  void countDownLatchTest() {
        /**
         * countDownLatch  ： 允许一个或多个线程等待其他线程完成操作
         * public CountDownLatch(int count) 初始化一个指定计数器的 countDownLatch对象
         * public void await throws InterruptedException 让当前线程等待
         * public void countDown()   计数器减一，计数器为0时，等待线程运行
         */
        CountDownLatch cdl = new CountDownLatch(1);
        new Thread(new MyThread6(cdl)).start();
        new Thread(new MyThread7(cdl)).start();
    }

    static class MyThread6 implements Runnable {

        public MyThread6(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        CountDownLatch cdl;

        @Override
        public void run() {
            System.out.println("a");
            System.out.println("waiting for b");

            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c");
        }
    }

    static class MyThread7 implements Runnable {

        public MyThread7(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        CountDownLatch cdl;

        @Override
        public void run() {
            System.out.println("b is ready");

            cdl.countDown();
        }
    }

    /**
     * CyclicBarrier test
     * 作用： 让一组线程到达一个屏障（同步点）时被阻塞，知道最后一个线程到达屏障时，所有线程才会继续执行。
     * public CyclicBarrier(int parties, Runnable barrierAction) 参数一：代表要达到屏障的线程数量，参数二：达到屏障后要执行的线程、
     * public int await() 每个线程调用await 告诉CyclicBarrier已经到达了屏障，然后当前线程被阻塞。
     */
    @Test
    public  void CyclicBarrierTest() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new BossThread());
        WorkerThread worker = new WorkerThread(cyclicBarrier);
        new Thread(worker, "张三").start();
        new Thread(worker, "李四").start();
        new Thread(worker, "王五").start();
        new Thread(worker, "赵六").start();
        new Thread(worker, "daryl").start();
    }

    static class WorkerThread implements Runnable {

        CyclicBarrier cb;

        public WorkerThread(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到达会议室~~");
            //当线程到达会议室时暂停。
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "离开了会议~~~");
        }
    }

    static class BossThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Boss is coming , lets get start!");
        }
    }

    /**
     * semaphore test
     * 作用： 控制线程的并发数量
     * public Semaphore(int permits)   指定许可线程的数量
     * public void acquire() throws InterruptedException  获取许可
     * public void release()  释放许可
     */
    @Test
    public  void semaphoreTest() {
        StudentThread st = new StudentThread(new ClassRoom());
        new Thread(st, "张三").start();
        new Thread(st, "李四").start();
        new Thread(st, "王五").start();
        new Thread(st, "赵六").start();
        new Thread(st, "daryl").start();
    }

    static class ClassRoom {

        Semaphore sp = new Semaphore(2);

        public void into() {
            try {
                sp.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is coming !");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "is out!");
            sp.release();
        }
    }

    static class StudentThread implements Runnable {

        ClassRoom cr;

        public StudentThread(ClassRoom cr) {
            this.cr = cr;
        }

        @Override
        public void run() {
            cr.into();
        }
    }

    /**
     * exchanger test
     */
    public static void exchangerTest() {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new MyThread1(ex)).start();
        new Thread(new MyThread2(ex)).start();
    }

    static class MyThread1 implements Runnable {

        Exchanger<String> ex;

        public MyThread1(Exchanger<String> ex) {
            this.ex = ex;
        }

        @Override
        public void run() {
            //线程1传递数据给线程2
            try {
                String message2 = ex.exchange("message 1 ");
                System.out.println("线程2 传递给线程1 的信息是" + message2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 implements Runnable {

        static boolean flag = false;

        Exchanger<String> ex;

        public MyThread2(Exchanger<String> ex) {
            this.ex = ex;
        }

        public MyThread2() {
        }

        @Override
        public void run() {
            String message1 = null;
            try {
                message1 = ex.exchange("message 2 ");
                System.out.println("线程1 传递给线程2 的数据为" + message1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 线程池测试
     */
    public static void threadPoolTest() throws Exception{
        //创建一个线程池对象,该线程池中有三条线程
        ExecutorService pool = Executors.newFixedThreadPool(3);
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
//        pool.submit(threadPoolTest);
//        pool.submit(threadPoolTest);
//        pool.submit(threadPoolTest);
//        pool.submit(threadPoolTest);

//        MyCallable myCallable = new MyCallable();
//        Future<String> future = pool.submit(myCallable);
//        pool.submit(myCallable);
//        pool.submit(myCallable);
//        pool.submit(myCallable);
//        pool.submit(myCallable);
//
//        System.out.println(future.get());

        MyCallable2 mc = new MyCallable2(5);
        Future<Integer> future = pool.submit(mc);
        pool.submit(mc);
//        System.out.println(pool.submit(mc).get());
//        System.out.println(pool.submit(mc).get());
//        System.out.println(pool.submit(mc).get());
//        System.out.println(pool.submit(mc).get());

        System.out.println(future.get());
        //销毁线程池，一般不操作
        //pool.shutdownNow();
    }

    static class ThreadPoolTest implements Runnable {

        @Override
        public void run() {
            //模拟执行任务
            System.out.println(Thread.currentThread().getName() + "执行任务中........");
        }
    }

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+"执行任务中。。。。。。");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName()+"任务执行结束.....");
            return "蒸的C";
        }
    }
    static class MyCallable2 implements Callable<Integer>{
        volatile int n;
        public MyCallable2(int n){
            this.n = n;
        }
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum+=i;
            }
            return sum;
        }
    }

    /**
     * 死锁测试
     * 产生死锁的条件： 1、有多把锁； 2、有多个线程； 3、有同步代码块嵌套。
     */
    public static void deadLockTest(){
        Object lockOne = new Object();
        Object lockTwo = new Object();

        //第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockOne){
                    System.out.println("第一个线程，拿到了 lockOne， 等待  lockTwo");
                    for (int i = 0; i < 100; i++) {
                        System.out.println(666);
                    }
//                    try {
//                        TimeUnit.SECONDS.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    synchronized (lockTwo){
                        System.out.println("第一个线程，同时拥有 lockOne 、 lockTwo，开始工作");
                    }
                }
                System.out.println("工作结束，释放锁");
            }
        }).start();

        //第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockTwo){
                    System.out.println("第二个线程，拿到了 lockTwo， 等待  lockOne");
                    synchronized (lockOne){
                        System.out.println("第二个线程，同时拥有 lockOne 、 lockTwo，开始工作");
                    }
                }
                System.out.println("finish");
            }
        }).start();
    }
}
