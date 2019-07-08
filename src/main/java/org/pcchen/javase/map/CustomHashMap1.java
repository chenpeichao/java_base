package org.pcchen.javase.map;

/**
 * 自定义hashmap v1.0版
 * @author ceek
 * @date 2019/7/4 20:00
 */
public class CustomHashMap1 {
    CustomEntity[] customEntities = new CustomEntity[999];

//    Integer size;     //默认初始值为null
    int size;
    public void put(Object key, Object value) {
        CustomEntity customEntity = new CustomEntity(key, value);
        for(int i = 0; i < size; i++) {
            if(customEntity.getKey().equals(customEntities[i].getKey())) {
                customEntities[i].setValue(value);
            }
        }
        customEntities[size++] = customEntity;
    }

    public Object get(Object key) {
        for(int i = 0; i < size; i++) {
            if(customEntities[i].getKey().equals(key)) {
                return customEntities[i].getValue();
            }
        }
        return null;
    }

    public Boolean containsKey(Object key) {
        for(int i = 0; i < size; i++) {
            if(customEntities[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CustomHashMap1 customHashMap = new CustomHashMap1();
        customHashMap.put("k1", "v1");
        customHashMap.put("k2", "v2");
        customHashMap.put("k3", "v3");

        System.out.println(customHashMap.get("k1"));
        System.out.println(customHashMap.containsKey("k1"));
    }
}

class CustomEntity{
    private Object key;
    private Object value;

    public CustomEntity() {
    }

    public CustomEntity(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}