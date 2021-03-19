package com.Algorithms.collection;

import java.util.*;

/**
 * @Description TODO
 * @Author ZY
 * @Date 2021/1/6 14:44
 **/
public class testList {
    // 50000个数
    public static final int N = 50000;
    // 要查找的集合
    public static List values;
    // 将50000个数给values
    static {
        Integer vals[] = new Integer[N];
        Random r = new Random();
        for (int i = 0,currval=0; i < N ; i++) {
            vals = new Integer[currval];
            currval += r.nextInt(100)+1;
        }
        values = Arrays.asList(vals);
    }
    // 通过二分查找法查找
    static long timeList(List lst) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int index = Collections.binarySearch(lst,values.get(i));
            if (index != i) {
                System.out.println("***错误***");
            }
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList消耗时间："+timeList(new ArrayList(values)));
        System.out.println("LinkedList消耗时间：" + timeList(new LinkedList(values)));

        /**
         * 输出结果：
         * ArrayList消耗时间：15
         * LinkedList消耗时间：2596
         */
    }
}
