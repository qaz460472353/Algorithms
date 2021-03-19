package com.Algorithms.map;

import java.util.*;

/**
 * @Description HashMap排序
 * @Author ZY
 * @Date 2021/1/6 9:04
 **/
public class HashMapSort {
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1,new User("张三",26));
        users.put(2,new User("李四",22));
        users.put(3,new User("王五",28));
        System.out.println(users);
        HashMap<Integer, User> sortMap = sortMap(users);
        System.out.println(sortMap);

    }

    private static HashMap<Integer, User> sortMap(HashMap<Integer, User> map) {
        // 首先拿到map键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();

        // 将set集合转换为list集合,使用工具类中的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
        // 使用Collections集合工具类对list进行排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                // 按照要求根据user的age排序
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        // 创建一个新的有序的hashMap子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        // 将list数据存储在LinkedHashMap中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }

        return linkedHashMap;
    }
}
