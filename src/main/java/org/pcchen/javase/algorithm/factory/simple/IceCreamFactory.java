package org.pcchen.javase.algorithm.factory.simple;

import org.pcchen.javase.algorithm.factory.AppleIceCream;
import org.pcchen.javase.algorithm.factory.BananaIceCream;
import org.pcchen.javase.algorithm.factory.IceCream;
import org.pcchen.javase.algorithm.factory.OrangeIceCream;

/**
 * 冰淇淋生成工程
 *
 * @author: ceek
 * @create: 2022/8/24 21:11
 */
public class IceCreamFactory {
    public static IceCream creamIceCream(String taste){
        IceCream iceCream = null;
        // 这里我们通过switch来判断，具体制作哪一种口味的冰激凌
        switch(taste){
            case "Apple":
                iceCream = new AppleIceCream();
                break;
            case "Orange":
                iceCream = new OrangeIceCream();
                break;
            case "Banana":
                iceCream = new BananaIceCream();
                break;
            default:
                break;
        }
        return iceCream;
    }
}
