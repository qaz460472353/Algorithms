package com.Algorithms.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 螺旋矩阵
 * @Author ZY
 * @Date 2021/3/16 19:25
 **/
public class HelixMatrix {
    /**
     * 1、给你一个 `m` 行 `n` 列的矩阵 `matrix` ，
     * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        // 行列
        int rows = matrix.length, columns = matrix[0].length;
        // 是否访问
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        // 方向控制二维数组
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 方向索引
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0],
                    nextColumn = column + directions[directionIndex][1];
            // 矩阵长宽相等
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0
                    || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }

    /**
     * 2、给一个正整数n，生成一个包含1到n²所有元素，
     * 且元素按顺时针顺序螺旋排列的n*n正方形矩阵matrix。
     */
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        // 右下左上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0],
                    nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0
                    || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                // 顺时针旋转至下一个方向
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }
}
