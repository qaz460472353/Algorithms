package recursion;

public class fibonacci {
    public static void main(String[] args) {
        int[] arrays = {1, 1, 2, 3, 5, 8, 13, 21};
        int fibonacci = fibonacci(10);
    }

    /**
     * 斐波那契数列
     *  前两项之和等于第三项： {1 1 2 3 5 8 13 21 34 55..... n }
     *  出口： Z = (n-2) + (n-1)
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }
}
