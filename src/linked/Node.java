package linked;

/**
 * 定义一个类作为节点
 *      数据域
 *      指针域
 */
public class Node {
    //数据域
    public int data;
    //指针域，指向下一节点
    public Node next;
    public Node(){}
    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
