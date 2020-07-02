package org.pcchen.javase.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程实现方式第三种有返回值
 *
 * @author ceek
 * @create 2019-09-27 10:53
 **/
public class CallableDemo07 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> f = new FutureTask<String>(new MyThread());
        Thread thread = new Thread(f, "测试进程");

        thread.start();
        System.out.println(f.get());
    }
}


class MyThread implements Callable<String> {


    public String call() throws Exception {
        System.out.println("执行测试的callable方法");
        return "test";
    }
}