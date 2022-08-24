package org.pcchen.javase.algorithm.factory.simple;

import org.pcchen.javase.algorithm.factory.IceCream;

/**
 * 简单工厂模式客户端：通过统一的工厂，传入不同参数调用生产冰激凌的方法去生产不同口味的冰激凌
 *
 * @author: ceek
 * @create: 2022/8/24 21:11
 */
public class Client {
    public static void main(String[] args) {
        IceCream appleIceCream = IceCreamFactory.creamIceCream("Apple");
        appleIceCream.taste();

        IceCream bananaIceCream = IceCreamFactory.creamIceCream("Banana");
        bananaIceCream.taste();

        IceCream orangeIceCream = IceCreamFactory.creamIceCream("Orange");
        orangeIceCream.taste();
    }
}
