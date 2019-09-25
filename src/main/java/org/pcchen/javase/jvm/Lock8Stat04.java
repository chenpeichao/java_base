package org.pcchen.javase.jvm;

import java.util.concurrent.TimeUnit;

/**
 * 锁的8种不同场景演示
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
            phone1.sendEmail();
        }).start();
    }
}

class Phone {
    public synchronized void sendMSM() {
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