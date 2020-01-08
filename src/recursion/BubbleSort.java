package recursion;

import java.util.Arrays;

/**
 * 冒泡排序递归写法
 *     思想：
 *          当第一趟排序后，我们可以将数组最后一位(R)和数组前面的数(L,R-1)进行切割，
 *          数组前面的数(L,R-1)看成是一个整体，这个整体又是和我们的初始目的(找出最大值，与当前趟数的末尾处交换)是一样的
 *     递归出口：
 *          当只有一个元素时，即不用比较了：L==R
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrays = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};
        System.out.println(bubbleSort(arrays, 0, arrays.length - 1));
    }

    public static String bubbleSort(int[] arrays, int L, int R) {
        int temp;

        //如果只有一个元素，返回
        if (L == R){

        } else {
            for (int i = L; i < R; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                }
            }
            //第一趟排序后已经将最大值放到数组后面

            //接下来就是“整体”的数据
            bubbleSort(arrays,L,R-1);
        }
        return Arrays.toString(arrays);
    }
}
