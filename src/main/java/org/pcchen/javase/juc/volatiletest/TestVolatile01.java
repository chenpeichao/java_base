package org.pcchen.javase.juc.volatiletest;

/**
 * 自增操作验证volatile的不保证原子性
 * @author: ceek
 * @create: 2022/5/12 17:36
 */
public class TestVolatile01 {
    //原子性验证
    public static void main(String[] args) {
        TmpTestVolatile01 tmp = new TmpTestVolatile01();
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
        System.out.println(tmp.inc);
    }
}

class TmpTestVolatile01{
    volatile int inc = 0;
    //再此方法中添加synchronized可保证原子性
    public void inc() {
        inc++;
    }
}