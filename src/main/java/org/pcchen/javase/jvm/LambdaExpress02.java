package org.pcchen.javase.jvm;

/**
 * lambda表达式练习
 * 语法：拷贝小括号，写死右箭头，落地大括号
 *
 * @author ceek
 * @create 2019-09-24 13:52
 **/
public class LambdaExpress02 {
    public static void main(String[] args) {
        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello jerry!");
//            }

            @Override
            public int mul(int a, int b) {
                return a + b;
            }
        };

        System.out.println(foo.add(2, 3));
//        foo.sayHello();


        Foo foo2 = (x, y) -> {
            System.out.println("");
            return 1;
        };
        int result = foo2.add(1, 2);
        System.out.println(result);
    }

}

@FunctionalInterface
//当使用@FunctionalInterface注解时，类中有且仅有一个无方法体的方法
interface Foo {
//    public void sayHello();

    public default int add(int a, int b) {
        return a + b;
    }

    public default int add(int a, int b, int c) {
        return a + b;
    }

    public int mul(int a, int b);
//    public int mul2(int a, int b, int c);
}