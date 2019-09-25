package org.pcchen.javase.jvm;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类安全测试
 * <p>
 * 多线程故障
 * 现象：产生java.util.ConcurrentModificationException异常
 * 导致原因：多线程争抢同一资源类，没有注意线程安全问题
 * 解决：比如集合使用CopyOnWrite**，ConcurrentHashMap等线程安全api
 * 避免：不出错
 *
 * @author ceek
 * @create 2019-09-25 10:03
 **/
public class NotSafeCollection03 {
    public static void main(String[] args) {
//        NotSafeCollection03.removeEleInLoopList();
        NotSafeCollection03.removeEleInLoopSet();
    }

    public static void removeEleInLoopSet() {
        //        List<String> list = Collections.synchronizedList(new ArrayList<String>());    //不支持遍历时移除
        Set<String> set = new CopyOnWriteArraySet<>();       //支持遍历时移除
        for (int i = 0; i < 10; i++) {
            set.add(String.valueOf(i));
        }

        set.forEach(x -> {
            if ("5".equals(x)) {
                set.remove(x);
            }
        });
        System.out.println(set);
    }

    public static void removeEleInLoopList() {
        //        List<String> list = Collections.synchronizedList(new ArrayList<String>());    //不支持遍历时移除
        List<String> list = new CopyOnWriteArrayList<>();       //支持遍历时移除
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        list.forEach(x -> {
            if ("5".equals(x)) {
                list.remove(x);
            }
        });
        System.out.println(list);
    }

    public static void mapNotSafe() {
        Map<Object, Object> map = new HashMap<Object, Object>();      //线程不安全
//        Map<Object, Object> map = new ConcurrentHashMap<Object, Object>();

        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 4), UUID.randomUUID().toString().substring(0, 4));
                System.out.println(map);
            }).start();
        }
    }

    public static void setNotSafe() {
//        Set<String> set = new HashSet<String>();    //线程不安全，内部实现为HashMap，value值为new一个Object
//        Set<String> set = Collections.synchronizedSet(new HashSet<String>());   //线程安全：add中使用synchronized修饰当前对象
        Set<String> set = new CopyOnWriteArraySet<String>(); //线程安全，内部实现为CopyOnWriteArrayList

        for (int i = 0; i <= 40; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }).start();
        }
    }

    public static void listNotSafe() {
//        List<String> list = new ArrayList<String>();  //线程不安全；底层实现为默认10大小的Object[]
//        List<String> list = new Vector();     //是线程安全的，add方法添加synchronized关键字
//        List<String> list = Collections.synchronizedList(new ArrayList<String>()); //线程安全：内部看形参中的实例如果不是RandomAccess，则新建SynchronizedList,add中使用synchronized修饰当前对象
        List<String> list = new CopyOnWriteArrayList<String>(); //线程安全的，使用重入锁，复制一份集合，然后再重新指向集合

        for (int i = 0; i <= 130; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "A").start();
        }
    }
}
