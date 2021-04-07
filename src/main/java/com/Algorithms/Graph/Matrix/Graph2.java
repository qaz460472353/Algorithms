package com.Algorithms.Graph.Matrix;

public class Graph2 {
    //表示顶点的个数
    private final int MAX_VERTS = 20;
    //用来存储顶点的数组
    private Vertex vertexList[];
    //用邻接矩阵来存储边，数组元素表示没有边界，1表示有边界
    private int adjMat[][];
    //顶点个数
    private int nVerts;
    //用栈实现深度优先搜索
    private StackX theStack;
    //用队列实现广度优先搜索
    private QueueX queue;

    /**
     * 顶点类
     */
    class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }
    }

    public Graph2() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        //初始化顶点个数为0
        nVerts = 0;
        //初始化邻接矩阵所有元素都为0，即所有顶点都没有边
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new StackX();
        queue = new QueueX();
    }

    //将顶点添加到数组中，是否访问标志置为wasVisited=false（未访问）、
    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    //注意用邻接矩阵表示边，是对称的，两部分都要赋值
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //打印某个顶点表示的值
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    /**
     * 深度优先搜索算法
     * 1、用peek方法检查栈顶的顶点
     * 2、用getAdjUnvisitedVertex方法找到当前栈顶邻接且未被访问的顶点
     * 3、第二步返回值不等于-1则找到下一个未访问的邻接顶点，访问这个顶点，并入栈
     * 如第二步返回值等于-1，则没有找到，出栈
     */
    public void depthFirstSearch() {
        //从第一个顶点开始访问,访问之后标记为true
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            //找到栈当前顶点邻接且未被访问的顶点
            int v = getAdjUnvisitedVertex(theStack.peek());
            //如果当前顶点值为-1，则表示没有邻接且未被访问的顶点，那么出栈顶点
            if (v == -1) {
                theStack.pop();
            } else {
                //否则访问下一个邻接点
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        //栈访问完毕，重置所有标记位为false
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    //找到与某一顶点邻接且未被访问的顶点
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            //v顶点与i顶点相邻且未被访问
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }

        }
        return -1;
    }

    /**
     * 广度优先搜索
     * 1、用remove方法检查栈顶的栈顶
     * 2、试图找到这个顶点还未被访问的邻接点
     * 3、如果没有找到，该顶点出列
     * 4、如果找到这样的顶点，访问这个顶点，并把它放入队列中
     */
    public void breadthFirstSearch() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        //搜索完毕，初始化，便于下次搜索
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph2 graph = new Graph2();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0, 1);//AB
        graph.addEdge(1, 2);//BC
        graph.addEdge(0, 3);//AD
        graph.addEdge(3, 4);//DE

        System.out.println("深度优先搜索算法：");
        graph.depthFirstSearch();

        System.out.println();
        System.out.println("---------------");

        System.out.println("广度优先搜索算法：");
        graph.breadthFirstSearch();
    }

}
