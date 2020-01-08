package recursion;

/**
 * 递归
 *    条件：
 *      递归出口(终止递归的条件)
 *      递归表达式(规律)
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println("递归求和："+sum(100));
        int[] arr =  {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};
    }
    /**
     * 递归求和
     * @param n 要加到的数字，比如题目的100
     * @return
     */
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }else {
            return sum(n-1) + n;
        }
        /*
        //如果递归出口为4，(1+2+3+4)
        if (n == 4) {
            return 10;
        } else {
            return sum(n - 1) + n;
        }
        */
    }
    /**
     * 递归，找出数组最大的值
     *  思想：
     *      分为 1 和 整体。
     * @param arrays 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */

    public static int findMax(int[] arrays, int L, int R) {
        //如果该数组只有一个数，那么最大的就是该数组第一个值了。
        if (L == R) {
            return arrays[L];
        }else {
            int a = arrays[L];
            //找出整体的最大值
            int b = findMax(arrays,L+1,R);

            if (a > b) {
                return a;
            }else {
                return b;
            }
        }
    }
}
