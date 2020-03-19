package Hash;

public class Hash<K,V> {
    //默认容量
    int defaultCapacity = 16;
    //扩展因子
    private static float defaultLoadFactor = 0.75f;
    //存储头节点的数组
    private Node<K,V>[] nodes;
    //元素个数
    private int size;
    public V put(K key,V value) {
        //初始化数组
        if(nodes == null) {
            nodes = new Node[defaultCapacity];
        }
        //计算存储角标
        int index = hash(key);
        //获取到数组角标元素，可视为头结点
        Node<K,V> node = nodes[index];
    }


    /**
     * hash算法
     * @param key
     * @return
     */
    public int hash(K key) {
        //获取到Key的hashCode值
        int code = key.hashCode();
        //defaultCapacity为数组长度，默认为16
        return code%(defaultCapacity - 1);
    }
    /**
     * 单向链表
     *    节点对象
     */
    public class Node<K,V> {
        K key;
        V value;
        //下一个节点对象
        Node<K,V> next;

        public Node(K key,V value,Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
