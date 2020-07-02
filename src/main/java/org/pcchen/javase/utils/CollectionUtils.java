package org.pcchen.javase.utils;

import org.pcchen.javase.map.PersonDemo;

import java.util.*;

/**
 * java集合操作
 *
 * @author ceek
 * @create 2019-12-27 16:19
 **/
public class CollectionUtils {
    public static void main(String[] args) {
//        List<Integer> maxIntList = new ArrayList<Integer>();
//
//        maxIntList.add(1);
//        maxIntList.add(2);
//        maxIntList.add(3);
//        maxIntList.add(4);
//        maxIntList.add(4);
//
//        getMaxInt(maxIntList);
//
//        List<PersonDemo> personDemoList = new ArrayList<PersonDemo>();
//        personDemoList.add(new PersonDemo("zs", 2));
//        personDemoList.add(new PersonDemo("ls", 3));
//        personDemoList.add(new PersonDemo("ww", 5));
//        personDemoList.add(new PersonDemo("zl", 5));
//        getMaxPersonDemo(personDemoList);
        Map<String, Integer> maxMap = new HashMap<String, Integer>();
        maxMap.put("zs", 2);
        maxMap.put("ls", 3);
        maxMap.put("ww", 1);
        maxMap.put("zl", 7);
        getMaxMap(maxMap);

        Set<String> s = new HashSet<String>();
    }

    public static void getMaxInt(List<Integer> maxList) {
//        int max = maxList.stream().mapToInt(x -> x).max().getAsInt();
//        int max2 = maxList.stream().max(Comparator.comparing(o -> o)).get();
//        System.out.println(max);
//        System.out.println(max2);
    }

    public static void getMaxPersonDemo(List<PersonDemo> maxList) {
//        PersonDemo personDemo = maxList.stream().max(Comparator.comparing(x -> x.getAge())).get();
//        Optional<PersonDemo> max = maxList.stream().filter(PersonDemo::getAge).max(Comparator.comparing(x -> x.getAge()));
//        PersonDemo personDemo1 = max.orElse(new PersonDemo("无效", 12));
////        System.out.println(personDemo);
//        System.out.println(personDemo1);
//        System.out.println(maxList.stream().max(Comparator.comparing(PersonDemo::getAge)).get());
//        System.out.println(maxList.stream().filter(x -> x.getAge() != null).mapToInt(x -> x.getAge()).max().getAsInt());
//
//        //summarizingInt返回count/sum/min/average/max
//        System.out.println(maxList.stream().collect((Collectors.summarizingInt(PersonDemo::getAge))));
//        System.out.println(maxList.stream().collect((Collectors.averagingInt(PersonDemo::getAge))).doubleValue());
    }

    public static void getMaxMap(Map<String, Integer> map) {
//        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
//        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(x -> result.put(x.getKey(), x.getValue()));
//        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(x -> result.put(x.getKey(), x.getValue()));
//        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        System.out.println(map.entrySet().iterator().next());
    }
}
