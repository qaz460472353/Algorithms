package com.Algorithms.Graph.Matrix;

/**
 * 实现深度优先搜索的栈
 */
public class StackX {
    private final int SIZE = 20;
    // 模拟栈的数组
    private final int[] st;
    // 栈顶
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
