package org.pcchen.javase.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的精确唤醒Condition初探
 * 通过lock新建Condition来实现不同的condition处理
 *
 * @author ceek
 * @create 2019-09-26 17:53
 **/
public class ConditionDemo06 {
    public static void main(String[] args) {
//        ShareData shareData = new ShareData();
//
//        new Thread(() -> {
//            for(int i = 0; i < 3; i++) {
//                shareData.print5();
//            }
//        }, "A").start();
//        new Thread(() -> {
//            for(int i = 0; i < 3; i++) {
//                shareData.print10();
//            }
//        }, "B").start();
//        new Thread(() -> {
//            for(int i = 0; i < 3; i++) {
//                shareData.print15();
//            }
//        }, "C").start();

        Lock lock = new ReentrantLock();

        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        AtomicInteger gloabFlag = new AtomicInteger(1);

        ShareDataTotal shareDataTotal = new ShareDataTotal();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareDataTotal.printTotal(lock, condition1, condition2, 1, 2, gloabFlag, 5);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareDataTotal.printTotal(lock, condition2, condition3, 2, 3, gloabFlag, 10);
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareDataTotal.printTotal(lock, condition3, condition1, 3, 1, gloabFlag, 15);
            }
        }, "C").start();
    }
}

class ShareData {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();

        try {
            while (flag != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();

        try {
            while (flag != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();

        try {
            while (flag != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ShareDataTotal {
    public void printTotal(Lock lock, Condition executeCon, Condition nextCon, Integer executeFlag, Integer nextFlag, AtomicInteger gloabFlag, Integer printCount) {
        lock.lock();

        try {
            while (executeFlag != gloabFlag.get()) {
                executeCon.await();
            }

            for (int i = 1; i <= printCount; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            gloabFlag.set(nextFlag);
            nextCon.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}