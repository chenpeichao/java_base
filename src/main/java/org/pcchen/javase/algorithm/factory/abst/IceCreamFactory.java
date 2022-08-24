package org.pcchen.javase.algorithm.factory.abst;

/**
 * 冰淇淋生成工厂：包含口味和规格
 *
 * @author: ceek
 * @create: 2022/8/24 21:28
 */
public interface IceCreamFactory {
    public BigIceCream createBigIceCream();

    public SmallIceCream createSmallIceCream();
}