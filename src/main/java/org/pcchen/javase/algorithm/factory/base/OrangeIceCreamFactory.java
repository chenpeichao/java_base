package org.pcchen.javase.algorithm.factory.base;

import org.pcchen.javase.algorithm.factory.IceCream;
import org.pcchen.javase.algorithm.factory.OrangeIceCream;

/**
 * 橘子口味冰淇淋生成工厂
 *
 * @author: ceek
 * @create: 2022/8/24 21:18
 */
public class OrangeIceCreamFactory implements IceCreamFactory{

    public IceCream createIceCream() {
        return new OrangeIceCream();
    }
}