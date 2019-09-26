package org.pcchen.javase.jvm;

/**
 * 线程等待和唤醒demo
 * <p>
 * notify中使用wait要放在while循环里面，放在if中会产生线程安全问题
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
    }
}
