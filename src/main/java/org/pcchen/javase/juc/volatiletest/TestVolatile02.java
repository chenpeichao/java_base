package org.pcchen.javase.juc.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用atomic下安全类或synchronized保证原子性
 *
 * @author: ceek
 * @create: 2022/5/12 17:37
 */
public class TestVolatile02 {
    //原子性验证
    public static void main(String[] args) {
        TmpTestVolatile02 tmp = new TmpTestVolatile02();
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                for(int j = 0; j<1000; j++) {
                    tmp.inc();
                }
            }).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();/*主线程礼让*/
        }
        System.out.println(tmp.atomicInteger.get());
    }
}

class TmpTestVolatile02{
    //方式一：通过使用安全类
    volatile AtomicInteger atomicInteger = new AtomicInteger(0);
    //方式而：直接在此方法上添加synchronized
    public void inc() {
        atomicInteger.getAndIncrement();
    }
}