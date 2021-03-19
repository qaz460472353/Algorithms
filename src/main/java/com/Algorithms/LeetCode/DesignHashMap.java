package com.Algorithms.LeetCode;

/**
 * 设计哈希映射
 *
 * 此题主要考察哈希表的实现原理，主要知道哈希表是通过 数组 结构来实现，并且为了解决hash冲突，所以也使用了链表来共同实现即可完成该题。
 *
 * 解题思路
 *      1.首先自定义一个基础数字，用于计算出一个 hash 值即可。
 *      2.再定义一个足够使用的数组用于存放映射值即可。
 *      3.剩下的工作，无论是新增映射，修改映射，删除映射，操作流程都如下：
 *          3.1 首先计算出该映射的 hash 值
 *          3.2 再遍历该数组位上的链表
 *          3.3 执行对应功能即可
 *
 *  要实现哈希表映射，首先我们需要用到数组来存储映射关系
 *  但是，为了解决 hash 函数的返回值重复，导致多个数据映射在数组的同一索引位置
 *  我们就需要使用链表来存储对应键值对，便于查找
 *
 */
public class DesignHashMap {
    // 声明一个基本的数字，用于取余操作，计算出一个 hash 值
    int len = 996;
    // 声明一个足够大的空间来存储映射关系
    MapNode[] Node;

    class MapNode {
        int key;
        int value;
        MapNode next;

        public MapNode(){}

        public MapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public DesignHashMap() {
        Node = new MapNode[len];
    }
    /**
     * 若是数组某位上的 key 不存在，直接追加数据
     * 若是 key 已存在，修改对应 key 的值即可
     */
    public void put(int key,int value) {
        int index = hash(key);
        MapNode node = new MapNode(key,value);
        if (Node[index] == null) {
            Node[index] = node;
        } else {
            MapNode temp = Node[index],lastNode = null;
            // 遍历该数组某索引上的链表
            while (temp != null) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                lastNode = temp;
                temp = temp.next;
            }
            lastNode.next = node;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (Node[index] == null ) {
            return -1;
        }
        MapNode node = Node[index];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (Node[index] == null ) {
            return ;
        }
        MapNode node = Node[index], pre = null;
        while (node != null) {
            if (node.key == key) {
                if (pre == null) {
                    Node[index] = node.next;
                } else {
                    pre.next = node.next;
                }
            }
            pre = node;
            node = node.next;
        }
    }

    public int hash(int key) {
        return key * len;
    }

}

