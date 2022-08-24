package org.pcchen.javase.algorithm.factory.base;

import org.pcchen.javase.algorithm.factory.BananaIceCream;
import org.pcchen.javase.algorithm.factory.IceCream;

/**
 * 香蕉口味冰淇淋生成工厂
 *
 * @author: ceek
 * @create: 2022/8/24 21:17
 */
public class BananaIceCreamFactory  implements IceCreamFactory {

    public IceCream createIceCream() {
        return new BananaIceCream();
    }
}