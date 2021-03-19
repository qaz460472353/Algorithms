package com.Algorithms.stack;

/**
 * 栈：
 *    静态栈(数组实现)
 *    动态栈(链表实现)
 */
public class Stack {

    /**
     * 两个指针：
     *     栈顶、栈底
     */
    public Node stackTop;
    public Node stackBottom;

    /**
     * 进栈
     *
     * @param stack 栈
     * @param value 要进栈的元素
     */
    public void pushStack(Stack stack, int value) {
        if (stackBottom == null) {
            stackBottom = new Node(value);
            stackTop = stackBottom;
        }else {
            Node node = new Node(value);
            // 栈顶本来指向的节点交由新节点来指向
            node.next = stackTop;
            // 栈顶指针指向新节点
            stackTop = node;
            /*
            //前栈顶的元素作为当前结点的前结点
            node.pre = stackTop;
            //栈顶指向新添加的那个结点
            stackTop = node;
            */
        }
    }
    /**
     * 遍历栈(只要栈顶指针不指向栈底指针，就一直输出)
     *
     * @param stack 栈
     */
    public void traverse(Stack stack) {
        Node stackTop = stack.stackTop;
        System.out.println("栈顶："+stackTop.data);
        while (stackTop != stackBottom) {
            stackTop = stackTop.next;
            System.out.println("遍历栈："+stackTop.data);
        }
    }

    /**
     * 出栈(将栈顶的指针指向下一个节点)
     * @param stack 栈
     */
    public static void popStack(Stack stack) {
        // 栈不为空才能出栈
        if (stack.stackTop != null) {
            //栈顶元素
            Node top = stack.stackTop;
            System.out.println("---->出栈的元素是：" + top.data);
            // 栈顶指针指向下一个节点
            stack.stackTop = top.next;
            if (top.next == null) {
                System.out.println("已经到栈底啦");
            }
        }else {
            System.out.println("---->出栈为空");
        }
    }
    /**
     * 清空栈
     *  C 需要释放内存资源，可是Java不用呀，所以栈顶指向栈底，就清空栈了
     * @param stack 栈
     */
    public static void clearStack(Stack stack) {
        stack.stackTop = null;
        stack.stackBottom = stack.stackTop;
    }

    public static void main(String[] args) {
        //初始化栈(无元素)
        Stack stack = new Stack();
        //栈顶和栈尾是同一指向
        stack.stackBottom = stack.stackTop;
        //指向null
        //com.Algorithms.stack.stackTop.next = null;

        //进栈
        stack.pushStack(stack, 3);
        stack.pushStack(stack, 4);
        stack.pushStack(stack, 5);
        stack.pushStack(stack, 6);

        stack.traverse(stack);

        //出栈
        popStack(stack);
        popStack(stack);
        popStack(stack);
        popStack(stack);
    }
}
