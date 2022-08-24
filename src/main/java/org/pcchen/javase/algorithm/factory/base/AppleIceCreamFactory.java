package org.pcchen.javase.algorithm.factory.base;

import org.pcchen.javase.algorithm.factory.AppleIceCream;
import org.pcchen.javase.algorithm.factory.IceCream;

/**
 * 苹果口味冰淇淋生成工厂
 *
 * @author: ceek
 * @create: 2022/8/24 21:16
 */
public class AppleIceCreamFactory  implements IceCreamFactory {

    public IceCream createIceCream() {
        return new AppleIceCream();
    }
}