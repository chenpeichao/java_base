package org.pcchen.javase.algorithm.singleton;

/**
 * 双重检查锁---单例模式
 * @author ceek
 * @create 2022/4/24 18:02
 **/
public class DCLSingleton {
    //懒加载验证指令重排
    private static DCLSingleton instance;

    //避免指令重排时，定义为如下内容
//    private volatile static DCLSingleton dclSingleton;

    private DCLSingleton(){}
    public static DCLSingleton getInstance() {
        if ( instance == null ) { //当instance不为null时，仍可能指向一个“被部分初始化的对象”
            synchronized (DCLSingleton.class) {
                if ( instance == null ) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}