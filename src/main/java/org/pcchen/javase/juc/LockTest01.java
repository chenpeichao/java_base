package org.pcchen.javase.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程轻量级锁lock
 *
 * @author ceek
 * @create 2019-09-24 9:54
 **/
public class LockTest01 {
    public static void main(String[] args) {
        LockBean lockBean = new LockBean();

        new Thread(() -> {
        }, "A").start();

        List<Object> abc = new ArrayList<Object>();
        abc.forEach(x -> {
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    lockBean.add();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    lockBean.add();
//                    try {
//                        Thread.currentThread().sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    lockBean.add();
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    lockBean.add();
                }
            }
        }, "D").start();
    }
}


class LockBean {
    private int num = 0;

    private Lock lock = new ReentrantLock();

    public void add() {


        if (num < 100) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                num++;
            }
            System.out.println("当前线程为【" + Thread.currentThread().getName() + "】累计了一条数据，现在的值为" + num);
        }
//        lock.lock();
//
//        try {
//            if(num < 100) {
//                Thread.currentThread().sleep(5);
//                num++;
//                System.out.println("当前线程为【" + Thread.currentThread().getName() + "】累计了一条数据，现在的值为" + num);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
    }
}