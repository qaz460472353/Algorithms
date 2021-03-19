package com.Algorithms.recursion;

/**
 * 汉诺塔
 *    规则:
 *       有三根柱子，原始装满大小不一的盘子的柱子我们称为A，还有两根空的柱子，我们分别称为B和C(任选)
 *       最终的目的就是将A柱子的盘子全部移到C柱子中
 *          移动的时候有个规则：一次只能移动一个盘子，小的盘子不能在大的盘子上面(反过来：大的盘子不能在小的盘子上面)
 *
 *   规律：
 *      把 n-1 号盘子移动到中转柱子
 *      把最大盘子从起点移到目标柱子
 *      把中转柱子的n-1号盘子也移到目标柱子
 */
public class hanoi {
    public static void main(String[] args) {
        int[] arrays = {1, 1, 2, 3, 5, 8, 13, 21};
        hanoi(3, 'A', 'B', 'C');

    }
    /**
     * 汉诺塔
     * @param n n个盘子
     * @param start 起始柱子
     * @param transfer 中转柱子
     * @param target 目标柱子
     */
    public static void hanoi(int n, char start, char transfer, char target) {
        //只有一个盘子，直接搬到目标柱子
        if (n == 1) {
            System.out.println(start + "---->" + target);
        } else {
            //起始柱子借助目标柱子将盘子都移动到中转柱子中(除了最大的盘子)
            hanoi(n - 1, start, target, transfer);
            System.out.println(start + "---->" + target);
            //中转柱子借助起始柱子将盘子都移动到目标柱子中
            hanoi(n - 1, transfer, start, target);
        }
    }
}
