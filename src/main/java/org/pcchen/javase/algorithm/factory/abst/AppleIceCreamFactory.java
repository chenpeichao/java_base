package org.pcchen.javase.algorithm.factory.abst;

/**
 * 苹果口味冰淇淋生成工厂：包含口味和规格
 *
 * @author: ceek
 * @create: 2022/8/24 21:34
 */
public class AppleIceCreamFactory implements IceCreamFactory {
    public BigIceCream createBigIceCream() {
        return new BigAppleIceCream();
    }

    public SmallIceCream createSmallIceCream() {
        return new SmallAppleIceCream();
    }
}
