package com.Algorithms.Demo202101;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Description 用1,2,2,3,4,5这6个数字，打印出所有不同的排列
 *  要求：4不能在第三位，3和5不能相连
 * @Author ZY
 * @Date 2021/1/16 19:46
 **/
public class NumberRandom {
    String[] stra = {"1","2","2","3","4","5"};
    int n = stra.length;
    boolean[] visited = new boolean[n];
    String result = "";
    TreeSet<String> ts = new TreeSet<>();
    int[][] a = new int[n][n];
    private void searchMap() {
        // 遍历组合，去除重复
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i==j) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
        // 3和5不能相连
        a[3][5] = 0;
        a[5][3] = 0;
        // 开始遍历
        for (int i = 0; i < n; i++) {
            search(i);
        }
        // 打印输出
        Iterator<String> it = ts.iterator();
        int num = 0;
        while (it.hasNext()) {
            String str = it.next();
            // 4 don't put 3th
            if (str.indexOf("4") != 2) {
                System.out.println(str);
                num++;
            }
        }
        System.out.println("共计："+num+"个");
    }
    private void search(int startIndex) {
        visited[startIndex] = true;
        result += stra[startIndex];
        if (result.length() == n) {
            ts.add(result);
        }
        for (int i = 0; i < n; i++) {
            if (a[startIndex][i] == 1 && visited[i] == false ) {
                search(i);
            } else {
                continue;
            }
        }
        // 一个result结束之后提到最后一个，寻找别的可能性，若没有的话，则继续向前踢当前最后一个
        result = result.substring(0,result.length()-1);
        visited[startIndex] = false;
    }

    public static void main(String[] args) {
        new NumberRandom().searchMap();
    }
}
