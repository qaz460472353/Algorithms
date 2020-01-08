package tree;

/**
 * 动态创建二叉查找树
 * 二叉查找树：
 * 定义：当前根节点的左边全部比根节点小，当前根节点的右边全部比根节点大。
 * 中序遍历二叉查找树得到的结果是排好顺序的.
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5};
        //动态创建树
        TreeRoot root = new TreeRoot();
        for (int value : arr) {
            createTree(root,value);
        }
        System.out.println("-----------中序遍历-----------");
        midTraverseBTree(root.getTreeRoot());
        System.out.println("-----------前序遍历-----------");
        preTraverseBTree(root.getTreeRoot());
    }

    /**
     * @param treeRoot 根节点
     * @param value    节点的值
     */
    public static void createTree(TreeRoot treeRoot, int value) {
        //如果树根为空(第一次访问)，将第一个值作为根节点
        if (treeRoot.getTreeRoot() == null) {
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);
        } else {
            //当前树根
            TreeNode tempRoot = treeRoot.getTreeRoot();
            while (tempRoot != null) {
                //当前值大于根值，往右边走
                if (value > tempRoot.getValue()) {
                    //右边没有树根，那就直接插入
                    if (tempRoot.getRightNode() == null) {
                        tempRoot.setRightNode(new TreeNode(value));
                        return;
                    }else {
                        //如果右边有树根，到右边的树根去
                        tempRoot = tempRoot.getRightNode();
                    }

                } else {
                    // 左边没有树根，那就直接插入
                    if (tempRoot.getLeftNode() == null) {
                        tempRoot.setLeftNode(new TreeNode(value));
                        return;
                    } else {
                        //如果左边有树根，到左边树根去
                        tempRoot = tempRoot.getLeftNode();
                    }
                }
            }
        }
    }
    /**
     * 先序遍历
     * @param rootTreeNode
     */
    public static void preTraverseBTree(TreeNode rootTreeNode) {
        if (rootTreeNode != null) {
            //先访问根节点
            System.out.println(rootTreeNode.getValue());
            //访问左节点
            preTraverseBTree(rootTreeNode.getLeftNode());
            //访问右节点
            preTraverseBTree(rootTreeNode.getRightNode());
        }
    }
    /**
     * 中序遍历
     * @param rootTreeNode
     */
    public static void midTraverseBTree(TreeNode rootTreeNode) {
        if (rootTreeNode != null) {
            //访问左节点
            preTraverseBTree(rootTreeNode.getLeftNode());
            //先访问根节点
            System.out.println(rootTreeNode.getValue());
            //访问右节点
            preTraverseBTree(rootTreeNode.getRightNode());
        }
    }

    /**
     * 查询树的深度
     * @param treeNode
     * @return
     */
    public static int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }else {
            //左边的子树深度
            int left = getHeight(treeNode.getLeftNode());
            //右边的子树深度
            int right = getHeight(treeNode.getRightNode());

            int max = left;

            if (right > max) {
                max = right;
            }
            return max + 1;
        }
    }

    /**
     * 查询树的最大值
     * @param treeNode
     * @return
     */
    public static int getMax(TreeNode treeNode) {
        if (treeNode == null) {
            return -1;
        }else {
            //找出左边的最大值
            int left = getMax(treeNode.getLeftNode());
            //找出右边的最大值
            int right = getMax(treeNode.getRightNode());
            //与当前根节点比较
            int currentRootValue = treeNode.getValue();
            //假设左边最大
            int max = left;

            if (right > max) {
                max = right;
            }
            if (currentRootValue > max) {
                max = currentRootValue;
            }
            return max;
        }
    }
}
