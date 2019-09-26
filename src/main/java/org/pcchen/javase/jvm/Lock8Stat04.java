package org.pcchen.javase.jvm;

import java.util.concurrent.TimeUnit;

/**
 * 锁的8种不同场景演示
 *
 * 对象锁：在资源类中，无论有多少同步方法，同一个线程访问资源类的同一个被synchronized修饰的方法或方法体中有synchronized (this)，他就会锁住该资源类的对象
 * 类锁：当在同步方法中添加static关键字或者在方法里使用synchronized(Demo.class)，用来定义全局锁
 *
 * 对象锁：只针对同一对象的有synchronid关键字修饰的方法
 * 类锁：只针对添加static synchronized关键字修饰的方法
 *
 * @author ceek
 * @create 2019-09-25 16:10
 **/
public class Lock8Stat04 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(() -> {
            phone1.sendMSM();
        }).start();

//        TimeUnit.SECONDS.sleep(1);

        Phone phone2 = new Phone();
        new Thread(() -> {
            phone2.sendEmail();
        }).start();
    }
}

class Phone {
    public static synchronized void sendMSM() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("***********sendMSM");
    }

    public synchronized void sendEmail() {
        System.out.println("*****sendEmail");
    }

    public void sayHello() {
        System.out.println("hello");
    }
}