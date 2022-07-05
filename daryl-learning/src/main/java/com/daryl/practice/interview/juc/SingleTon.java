package com.daryl.practice.interview.juc;

/**
 * 双重检验锁
 *
 * @author wl
 * @create 2022-03-21
 */
public class SingleTon {

    private static volatile SingleTon instance = null;

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
