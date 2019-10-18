package org.pcchen.javase.jvm;

/**
 * java内存模型测试
 *
 * @author ceek
 * @create 2019-10-18 9:21
 **/
public class JMMTest {
    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a is value " + Demo.a);
                demo.uploadAValue();
                System.out.println("a is change value " + Demo.a);
            }
        }, "A").start();

        Thread thread = new Thread();
        thread.yield();

        //当while方法中没有方法体时，则会进入死循环
        while (10 == Demo.a) {
//            try {
////                Thread.currentThread().sleep(10);
//                System.out.println(Demo.a);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("死循环调用");
        }
        System.out.println("The last a value is " + Demo.a);
    }
}


class Demo {
    public static int a = 10;

    public void uploadAValue() {
        a = 125;
    }
}