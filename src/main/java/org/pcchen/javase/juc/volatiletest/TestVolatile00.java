package org.pcchen.javase.juc.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * volatile可见性属性验证
 *
 * @author: ceek
 * @create: 2022/5/12 17:49
 */
public class TestVolatile00 {
    static volatile boolean flag = true;
    public static void main(String[] args) {
        new Thread(()-> {
            while (flag) {
                //死循环
            }
            System.out.println("线程一的输出");
        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程二的输出");
                flag = false;
            }
        }).start();
    }
}
