package com.Algorithms.Graph.Linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 用链表数组实现邻接表无向图
 *
 * @author XY
 * @date 20210407
 */
public class GraphByList {

    // 节点链表list，该list的每一项又是一个ArrayList,即每个节点相当于一个二维数组
    private List<ArrayList<Node>> nodeList;
    // 顶点最多个数
    private int maxCount;

    public static void main(String[] args) {
        // 初始化一个顶点数为5的链表集合
        GraphByList graphByList_5 = new GraphByList(5);

        // 给链表添加边
        // A --> B
        graphByList_5.addEdges(0, 1);
        // A --> D
        graphByList_5.addEdges(0, 3);
        // A --> E
        graphByList_5.addEdges(0, 4);
        // B --> 1
        graphByList_5.addEdges(1, 0);
        // B --> C
        graphByList_5.addEdges(1, 2);
        // B --> E
        graphByList_5.addEdges(1, 3);
        // C --> B
        graphByList_5.addEdges(2, 1);
        // C --> E
        graphByList_5.addEdges(2, 4);
        // D --> A
        graphByList_5.addEdges(3, 0);
        // D --> C
        graphByList_5.addEdges(3, 2);
        // E --> A
        graphByList_5.addEdges(4, 0);
        // E --> B
        graphByList_5.addEdges(4, 1);

        // 输出链表图
        graphByList_5.printNodeList();

    }

    /**
     * 初始化链表
     * @param count
     */
    public GraphByList(int count) {
        this.maxCount = count;

        // 初始化大小为maxCount的链表list
        nodeList = new ArrayList<ArrayList<Node>>(maxCount);

        // 初始化每个链表
        for (int i = 0; i < maxCount; i++) {
            // 初始化每个节点
            nodeList.add(new ArrayList<Node>());
        }
    }

    /**
     * 为顶点编号分别为i和j的两个顶点添加边
     * @param i 顶点i
     * @param j 顶点j
     */
    public void addEdges(int i, int j) {
        // 给编号为i的顶点一条添加指向编号为j的边
        nodeList.get(i).add(new Node(j));
    }

    /**
     *  输出链表图
     */
    public void printNodeList() {
        // 遍历每个顶点
        for (int i = 0; i < nodeList.size(); i++) {
            // 输出当前顶点编号
            System.out.print("顶点：" + i);

            // 获取当前节点下的所有节点
            ArrayList<Node> nodes = nodeList.get(i);
            // 遍历当前节点下所有的节点
            for (int j = 0; j < nodes.size(); j++) {
                System.out.print(" --> " + nodes.get(j).num);
            }

            // 该链表list遍历完成后回车继续下一个链表
            System.out.println(";");
        }
    }

    /**
     * 链表结点
     */
    class Node {
        int num;
        public Node(int num) {
            this.num = num;
        }

    }
}