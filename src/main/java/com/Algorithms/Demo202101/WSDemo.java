package com.Algorithms.Demo202101;

/**
 * @Description 找完数
 *  一个数如果恰好等于它的因子之和，这个数就称为完数，
 *      例如：6 = 1+2+3
 *      请找出1000以内的完数
 * @Author ZY
 * @Date 2021/1/16 21:29
 **/
public class WSDemo {
    public static void main(String[] args) {
        for (int i = 2; i < 1000; i++) {
            int s = 0;
            for (int j = 1; j < i ; j++) {
                if (i % j == 0) {
                    s +=j;
                }
            }
            if (s == i) {
                System.out.print(i + " it factors are:");
                for (int j = 1; j < i; j++) {
                    if (i%j == 0) {
                        System.out.print(j);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
