package com.Algorithms.linked;

/**
 * 链表排序
 */
public class LinkedSort {
    /**
     * 对链表进行排序
     *  冒泡排序
     *  数组换成了链表，其余一样
     * @param head
     */
    public static void sortLinkList(Node head) {
        Node currentNode;
        Node nextNode;
        for (currentNode = head.next; currentNode.next != null; currentNode = currentNode.next) {
            for (nextNode = head.next; nextNode.next != null; nextNode = nextNode.next) {
                if (nextNode.data > nextNode.next.data) {
                    int temp = nextNode.data;
                    nextNode.data = nextNode.next.data;
                    nextNode.next.data = temp;
                }
            }
        }
    }
}
