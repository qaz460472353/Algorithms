package com.Algorithms.中科三清;


public class MidFind {
    /**
     * 二分法查找一个数字在数组中第一次出现的位置
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, 3, 4, 5, 6, 6, 7, 11, 11, 46, 255, 743, 888};
        int len = arr.length;
        int temp = getLocation(arr, 11, 0, len);
        System.out.println(temp);
    }

    /**
     * @param arr   数组
     * @param key   需要找的数字
     * @param start 数组位置号，为数组下标+1
     * @param end   数组位置号，为数组下标+1
     * @return 位置索引，未找到返回 -1
     */
    public static int getLocation(int[] arr, int key, int start, int end) {
        if (arr == null) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (start <= end) {
            if (key == arr[middle]) {
                return middle;
            }
            if (key < arr[middle]) {
                return getLocation(arr, key, start, middle - 1);
            }
            return getLocation(arr, key, middle + 1, end);
        }
        return -1;
    }
}
