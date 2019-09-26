package org.pcchen.javase.jvm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程等待和唤醒demo
 * <p>
 * notify中使用wait要放在while循环里面，放在if中会产生线程虚假唤醒
 * wait和notify需要和synchronized搭配使用
 *
 * @author ceek
 * @create 2019-09-26 10:33
 **/
public class WaitAndNotifyAll05 {
    public static void main(String[] args) {
        Customer customer = new Customer();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customer.product();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customer.custom();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customer.product();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                customer.custom();
            }
        }, "D").start();
    }
}

class Customer {
    private int number = 0;
    private Lock lock = new ReentrantLock();    //可重入非公平递归锁
    private Condition condition = lock.newCondition();

    //使用较新的jdk的实现方式lock，实现线程安全
    public void product() {
        lock.lock();

        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void custom() {
        lock.lock();

        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /* jdk老版本中的线程安全
    //生产者
    public synchronized void product() {
        try {
            if (number != 0) {
                this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者
    public synchronized void custom() {
        try {
            if (number == 0) {
                this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
