package com.Algorithms.LeetCode;

/**
 * @Description 反转链表
 * @Author ZY
 * @Date 2021/3/19 11:55
 **/
public class ReverseLinked {
    /**
     * 反转一个单链表。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 方法：
     *      reverseList1 迭代法
     *      reverseList2 递归法
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 反转链表2
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 说明:
     *      1 ≤ m ≤ n ≤ 链表长度。
     * 示例:
     *      输入: 1->2->3->4->5->NULL, m = 2, n = 4
     *      输出: 1->4->3->2->5->NULL
     */
    class Solution {
        // 后驱节点
        ListNode successor = null;
        // 反转以 head 为起点的 n 个节点，返回新的头结点
        ListNode reverseN(ListNode head, int n) {
            if (n == 1 || head==null || head.next==null) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;
        }

        public ListNode reverseBetween(ListNode head, int left, int right) {
            if(head==null || head.next==null)  {
                return head;
            }
            // base case
            if (left == 1) {
                return reverseN(head, right);
            }
            // 前进到反转的起点触发 base case
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
