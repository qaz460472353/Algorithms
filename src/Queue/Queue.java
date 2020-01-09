package Queue;


public class Queue {
    //数组
    public int [] arrays;

    //指向第一个有效的元素
    public int front;

    //指向有效数据的下一个元素(即指向无效的数据)
    //rear 限制条件 =（rear+1) % arr.length
    public int rear;

    public static void main(String[] args) {
        //初始化队列
        Queue queue = new Queue();
        queue.front = 0;
        queue.rear = 0;
        /**
         * 此时队列为空，分配了6个长度给数组(只能装5个实际的数字，rear指向的是无效的位置的)
         */
        queue.arrays = new int[6];

        //入队
        enQueue(queue,1);
        enQueue(queue,2);
        enQueue(queue,3);
        //遍历
        traverseQueue(queue);
        //出队
        outQueue(queue);
        outQueue(queue);
        outQueue(queue);
        //空了
        outQueue(queue);
        outQueue(queue);

    }
    /**
     * 判断队列是否满了，front和rear指针紧挨着，就是满了
     * @param queue
     * @return
     */
    public static boolean isFull(Queue queue) {
        if ((queue.rear + 1) % queue.arrays.length == queue.front) {
            System.out.println("--->此时队列满了！");
            return true;
        } else {
            return false;
        }
    }
    /**
     * 入队
     *  1.判断该队列是否满了
     *  2.入队的值插入到队尾中(具体的位置就是rear指针的位置【再次声明：rear指向的是无效元素的位置】)
     *  3.rear指针移动(再次指向无效的元素位置)
     * @param queue
     */
    public static void enQueue(Queue queue,int value) {
        //不是满的队列才能入队
        if (!isFull(queue)) {
            //将新的元素插入到队尾中
            queue.arrays[queue.rear] = value;

            //rear节点移动到新的无效元素位置上
            queue.rear = (queue.rear + 1) % queue.arrays.length;
        }
    }
    /**
     * 遍历队列
     * 只要front节点不指向rear节点，那么就可以一直输出
     * @param queue
     *
     */
    public static void traverseQueue(Queue queue) {
        // front的位置
        int i = queue.front;
        while (i != queue.rear) {
            System.out.println("--->" + queue.arrays[i]);
            //移动front
            i = (i + 1) % queue.arrays.length;
        }
    }
    /**
     * 判断队列是否空，front和rear指针相等，就是空了
     * @param queue
     * @return
     */
    public static boolean isEmpty(Queue queue) {
        if (queue.rear  == queue.front) {
            System.out.println("--->此时队列空的！");
            return true;
        } else {
            System.out.println("--->此时队列非空！");
            return false;
        }
    }
    /**
     * 出队
     *    1.判断该队列是否为null
     *    2.如果不为null，则出队，只要front指针往后面移就是出队了!
     * @param queue
     */
    public static void outQueue(Queue queue) {
        //判断该队列是否为null
        if (!isEmpty(queue)) {
            //不为空才出队
            int value = queue.arrays[queue.front];
            System.out.println("--->出队的元素是：" + value);

            // front指针往后面移
            queue.front = (queue.front + 1) % queue.arrays.length;

        }
    }
}
