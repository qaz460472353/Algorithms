package com.Algorithms.Graph.Matrix;

public class Graph1 {
    static int[][] graph = new int[][]{
            //A, B, C, D, E, F
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
    };
    /**
     * 用来记录已经遍历过的元素
     */
    int[] help = new int[graph.length];

    /**
     * DFS(深度优先遍历)同样适用于有向图 A->C->B->D->E->F 即 0->2->1->3->4->5
     * <p>
     * 深度优先搜索是从起始顶点开始，递归访问其所有邻近节点，
     * 比如A节点是其第一个邻近节点，而C节点又是A的一个邻近节点，
     * 则DFS访问A节点后再访问C节点，如果C节点有未访问的邻近节点的话将继续访问其邻近节点，
     * 否则继续访问A的未访问邻近节点，当所有从A节点出去的路径都访问完之后，
     * 继续递归访问除A以外未被访问的邻近节点。
     * 所以上面我们的示意图的遍历顺序会是A->C->B->D->E->F。
     *
     * @param node  结点
     * @param graph 矩阵图
     */
    public void dfsTraversing(int node, int[][] graph) {
        help[node] = 1;
        System.out.println(node);
        for (int i = 0; i < graph[node].length; ++i) {
            if (help[i] == 0 && i != node && graph[node][i] == 1) {
                dfsTraversing(i, graph);
            }
        }
    }

    /**
     * BFS(广度优先遍历)同样适用于有向图 A->C->D->B->E->F 即 0->2->3->1->4->5
     * <p>
     * 其主要思想是从起始点开始，将其邻近的所有顶点都加到一个队列（FIFO）中去，
     * 然后标记下这些顶点离起始顶点的距离为1.最后将起始顶点标记为已访问，今后就不会再访问。
     * 然后再从队列中取出最先进队的顶点A，也取出其周边邻近节点，加入队列末尾，
     * 将这些顶点的距离相对A再加1，最后离开这个顶点A。依次下去，直到队列为空为止。
     * 从上面描述的过程我们知道每个顶点被访问的次数最多一次（已访问的节点不会再访问），
     * 而对于连通图来说，每个顶点都会被访问。加上每个顶点的邻接链表都会被遍历，
     * 因此BFS的时间复杂度是Θ（V+E），其中V是顶点个数，E是边数，也就是所有邻接表中的元素个数。
     * 所以我们上图的遍历顺序将会为：A->C->D->B->E->F
     *
     * @param graph
     */
    public void bfsTraversing(int[][] graph) {
        int[] queue = new int[graph.length];
        int cnt = 1;
        //将A作为起始顶点加入队列
        queue[0] = 0;
        help[0] = 1;
        System.out.println(0);
        for (int i = 0; i < cnt; ++i) {
            for (int j = 0; j < graph[queue[i]].length; ++j) {
                if (queue[i] != j && graph[queue[i]][j] == 1 && help[j] == 0) {
                    help[queue[i]] = 1;
                    queue[cnt++] = j;
                    System.out.println(j);
                }
            }
        }
    }
}
