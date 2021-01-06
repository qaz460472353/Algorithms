package Array;

/**
 * @Description 用面向对象的方法求出数组中重复 value 的个数
 * @Author ZY
 * @Date 2021/1/6 14:28
 **/
public class RepeatNum {
    public static void main(String[] args) {
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
        int[] num = new int[124];
        for (int i = 0; i < arr.length; i++) {
            num[arr[i]]++;
        }
        for (int j = 0; j < num.length; j++) {
            if (num[j] != 0 ) {
                System.out.println(j + "出现了" + num[j] + "次");
            }
        }
    }
}
