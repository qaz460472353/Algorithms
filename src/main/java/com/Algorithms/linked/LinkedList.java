package com.Algorithms.linked;

/**
 * 遍历、查找、清空、销毁、求长度、排序、删除节点、插入节点
 */
public class LinkedList {
    public static void main(String[] args) {
        //头结点
        Node head = new Node(1);
        addData(2,head);
        addData(3,head);
        addData(4,head);
        addData(5,head);

        traverse(head);
    }
    /**
     * 向链表添加数据
     * @param value 要添加的数据
     */
    public static void addData(int value,Node head) {
        //初始化要加入的节点
        Node newNode = new Node(value);
        //临时节点
        Node temp = head;
        // 找到尾节点
        while (temp.next!=null) {
            temp = temp.next;
        }
        //已经包括了头节点.next为null的情况了~
        temp.next = newNode;
    }

    /**
     * 遍历链表
     * @param head
     */
    public static void traverse(Node head) {
        //临时节点，从首节点开始
        Node temp = head;
        while (temp != null) {
            System.out.println("链表遍历："+temp.data);
            //继续下一个
            temp = temp.next;
        }
    }

    /**
     * 插入节点
     *     1、插入一个节点到链表中，首先得判断这个位置是否是合法的，才能进行插入～
     *     2、找到想要插入的位置的上一个节点就可以了～
     * @param head  头指针
     * @param index 要插入的位置
     * @param value 要插入的值
     */
    public static void insertNode(Node head, int index, int value) {
        //首先判断指定位置是否合法
        if (index < 1 || index > linkListLength(head)+1) {
            System.out.println("插入的位置不合法！");
            return;
        }
        //临时节点，从头结点开始
        Node temp = head;
        //记录遍历的当前位置
        int currentPos = 0;
        //初始化要插入的节点
        Node insertNode = new Node(value);
        while (temp.next != null) {
            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {
                //temp表示的是上一个节点
                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;
                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }
    /**
     * 获取链表的长度
     * @param head 头指针
     */
    public static int  linkListLength(Node head) {

        int length = 0;

        //临时节点，从首节点开始
        Node temp = head.next;

        // 找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }
    /**
     * 根据位置删除节点
     *
     * @param head  头指针
     * @param index 要删除的位置
     */
    public static void deleteNode(Node head, int index) {
        //首先需要判断指定位置是否合法，
        if (index < 1 || index > linkListLength(head) + 1) {
            System.out.println("删除位置不合法。");
            return;
        }
        //临时节点，从头节点开始
        Node temp = head;
        //记录遍历的当前位置
        int currentPos = 0;
        while (temp.next != null) {
            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {
                //temp表示的是上一个节点
                //temp.next表示的是想要删除的节点
                //将想要删除的节点存储一下
                Node deleteNode = temp.next;
                //想要删除节点的下一个节点交由上一个节点来控制
                temp.next = deleteNode.next;
                //Java会回收它，设置不设置为null应该没多大意义了(个人觉得,如果不对请指出哦～)
                deleteNode = null;

                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }
    /**
     * 找到链表中倒数第k个节点(设置两个指针p1、p2，让p2比p1快k个节点，同时向后遍历，当p2为空，则p1为倒数第k个节点
     *
     * @param head
     * @param k    倒数第k个节点
     */
    public static Node findKNode(Node head, int k) {
        if (k < 1 || k > linkListLength(head)) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        // p2比怕p1快k个节点
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        // 只要p2为null，那么p1就是倒数第k个节点了
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
    /**
     * 删除链表重复数据(跟冒泡差不多，等于删除就是了)
     *
     * @param head 头节点
     */
    public static void deleteDuplecate(Node head) {
        //临时节点，(从首节点开始-->真正有数据的节点)
        Node temp = head.next;
        //当前节点(首节点)的下一个节点
        Node nextNode = temp.next;
        while (temp.next != null) {
            while (nextNode.next != null) {
                if (nextNode.next.data == nextNode.data) {
                    //将下一个节点删除(当前节点指向下下个节点)
                    nextNode.next = nextNode.next.next;
                } else {
                    //继续下一个
                    nextNode = nextNode.next;
                }
            }
            //下一轮比较
            temp = temp.next;
        }
    }

    /**
     * 查询单链表的中间节点
     *      一个每次走1步，一个每次走两步，走两步的遍历完，然后走一步的指针，那就是中间节点
     *
     * @param head
     * @return
     */
    public static Node searchMid(Node head) {
        Node p1 = head;
        Node p2 = head;
        // 一个走一步，一个走两步，直到为null，走一步的到达的就是中间节点
        while (p2 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
    /**
     * 通过递归从尾到头输出单链表
     *
     * @param head 头节点
     */
    public  static  void printListReversely(Node head) {
        if (head != null) {
            printListReversely(head.next);
            System.out.println(head.data);
        }
    }
    /**
     * 实现链表的反转
     * @param node 链表的头节点
     */
    public static Node reverseLinkList(Node node) {
        Node prev;
        if (node == null || node.next == null) {
            prev = node;
        }else {
            Node temp = reverseLinkList(node.next);
            node.next.next = node;
            node.next = null;
            prev = temp;
        }
        return prev;
    }
}
