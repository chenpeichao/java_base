package org.pcchen.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射实现类
 * 反射获取类的方式：
 * 1、Class clazz = String.class
 * 2、Book book = new Book(); Class clazz = book.getClass();
 * 3、Class clazz = Class.forName("全限定类名"); //体现反射的动态性
 * 4、Class clazz = this.getClass().getClassLoader().loadClass("全限定类名");    //由于使用this，不能用在静态方法中
 *
 * @author ceek
 * @create 2020-09-24 15:22
 **/
public class ReflectClass {
    private final static String TAG = "org.pcchen.javase.reflect";

    /**
     * 反射对象
     */
    public static void reflectNewInstance(String name, String author) {
        try {
            Class<?> bookClass = Class.forName("org.pcchen.javase.reflect.Book");

            Book book = (Book) bookClass.newInstance();
            book.setName(name);
            book.setAuthor(author);

            System.out.println("通过getset函数创建" + book);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射私有的构造方法
     */
    public static void reflectPrivateConstructor(String name, String author) {
        try {
            Class<?> bookClass = Class.forName("org.pcchen.javase.reflect.Book");


            Constructor<?> declaredConstructorBook = bookClass.getDeclaredConstructor(String.class, String.class);
            Constructor<?> declaredConstructorBook2 = bookClass.getDeclaredConstructor();

            //反射私有构造方法需设置为可操作
            declaredConstructorBook.setAccessible(true);

            Book book = (Book) declaredConstructorBook.newInstance(name, author);
            Book book2 = (Book) declaredConstructorBook2.newInstance();
            System.out.println("通过私有构造函数创建" + book);
            System.out.println("通过构造函数创建2" + book2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取私有属性值
     *
     * @param classForName
     */
    public static void reflectPrivateField(String classForName) {
        try {
            Class<?> bookClass = Class.forName(classForName);

            Book book = (Book) bookClass.newInstance();
            Field tagField = bookClass.getDeclaredField("TAG");
            tagField.setAccessible(true);

            String tag = (String) tagField.get(book);
            System.out.println(tag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateDynamicField(String classForName) {
        try {
//            Book book = new Book();
//            book.setName("我就是我");

//            Class<?> bookClass = Class.forName(classForName);
//            Class<? extends Book> bookClass = book.getClass();
            Class<? extends Book> bookClass = Book.class;

            Book book = (Book) bookClass.newInstance();
            book.setName("wohaishiwo");

            Field nameField = bookClass.getDeclaredField("name");

            nameField.setAccessible(true);

            String name = (String) nameField.get(book);
            System.out.println(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 私有方法
     *
     * @param classForName
     */
    public static void reflectPrivateMethod(String classForName, int param) {
        try {
            Class<?> bookClass = Class.forName(classForName);

            Book book = (Book) bookClass.newInstance();

            Method declaredMethod = bookClass.getDeclaredMethod("declaredMethod", int.class);
            declaredMethod.setAccessible(true);

            String invokeResult = (String) declaredMethod.invoke(book, param);

            System.out.println("私有方法调用返回" + invokeResult);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
