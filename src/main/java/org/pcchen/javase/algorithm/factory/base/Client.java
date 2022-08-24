package org.pcchen.javase.algorithm.factory.base;

import org.pcchen.javase.algorithm.factory.IceCream;

/**
 * 普通工厂模式客户端
 *
 * @author: ceek
 * @create: 2022/8/24 21:19
 */
public class Client {
    public static void main(String[] args) {
        //生产苹果味冰激凌
        IceCreamFactory appleFactory = new AppleIceCreamFactory();
        IceCream appleIceCream = appleFactory.createIceCream();
        appleIceCream.taste();

        //生产香蕉口味冰激凌
        IceCreamFactory  bananaFactory = new BananaIceCreamFactory();
        IceCream bananaIceCream = bananaFactory.createIceCream();
        bananaIceCream.taste();

        //生产橘子口味冰激凌
        IceCream orangeIceCream = new OrangeIceCreamFactory().createIceCream();
        orangeIceCream.taste();
    }
}
