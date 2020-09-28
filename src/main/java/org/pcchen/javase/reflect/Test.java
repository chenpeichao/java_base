package org.pcchen.javase.reflect;

/**
 * 测试
 *
 * @author ceek
 * @create 2020-09-24 15:26
 **/
public class Test {
    public static void main(String[] args) {
        //创建对象
        ReflectClass.reflectNewInstance("书名1", "作者名1");

        //反射私有的构造方法
//        ReflectClass.reflectPrivateConstructor("书名2", "作者名2");

        //反射私有属性
//        ReflectClass.reflectPrivateField("org.pcchen.javase.reflect.Book");
//        ReflectClass.reflectPrivateDynamicField("org.pcchen.javase.reflect.Book");

        //反射私有方法
//        ReflectClass.reflectPrivateMethod("org.pcchen.javase.reflect.Book", 1);
    }
}
