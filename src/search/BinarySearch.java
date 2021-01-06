package search;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {9,6,7,3,5,22};
        Arrays.sort(arr);
        int key = 7;
        if (rank(key,arr) < 0) {
            System.out.println(key);
        }
    }

    public static int rank(int key,int[] a) {
        //数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            //被查找的键要么不存在，要么必然存在于a[lo..hi]中
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]) {
                hi = mid - 1;
            }else if (key > a[mid]) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}
