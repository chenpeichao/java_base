package org.pcchen.javase.jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试类加载器的类
 * 双亲委派机制：例如自定义一个java.lang.String类，其中包含main方法，运行，会和bootstrap加载器中的类冲突，则报错，找不到main方法
 * 沙箱安全机制：
 *
 * @author ceek
 * @create 2019-10-10 16:22
 **/
public class MyObject {
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1、应用程序类加载器---AppClassLoader，自己编写的走这个类加载器
        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());

        //2、javax开头的包则使用的是扩展类加载器---Extension；jre中的lib下的ext下面的jar包类

        //3、启动类加载器---Bootstrap，是系统自带的走这个加载器，如(jre中rt.jar中的的比如lang包下)：Object、String、ArrayList
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader()); //输出为null

        Class class2 = MyObject.class;
        Object o = class2.newInstance();
        Method method = class2.getMethod("sayHello", String.class);
        method.invoke(o, "xiaoming");

        System.out.println(class2.getName());
        System.out.println(class2.getCanonicalName());
    }
}