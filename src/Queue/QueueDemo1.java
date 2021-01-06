package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 两个队列模仿堆栈结构
 * @Author ZY
 * @Date 2021/1/6 14:58
 **/
public class QueueDemo1 {
    /**
     * 队列a和b
     *
     * (1)入栈： a、b队列为空，则将“a，b，c，d，e”需要入栈的元素放入a中，a进栈为“a，b，c，d，e”
     * (2)出栈： a队列目前元素为：“a，b，c，d，e”，将a队列依次放入ArrayList集合a中，以倒序的方法，将a中的集合取出，放入b队列中，
     * 再将b队列出列。
     */
    public static void main(String[] args) {
        Queue<String> a = new LinkedList<String>();
        Queue<String> b = new LinkedList<String>();
        // 中间参数
        ArrayList<String> arrayList = new ArrayList<>();
        a.offer("a");
        a.offer("b");
        a.offer("c");
        a.offer("d");
        a.offer("e");
        System.out.print("进栈：");
        // 将a队列依次插入list集合之中
        for (String q : a) {
            arrayList.add(q);
            System.out.print(q);
        }
        // 以倒序方法取出
        for (int i = arrayList.size() - 1; i >= 0 ; i-- ) {
            b.offer(arrayList.get(i));
        }
        // 打印出栈队列
        System.out.println("");
        System.out.print("出栈：");
        for (String s : b) {
            System.out.println(s);
        }
    }
}
