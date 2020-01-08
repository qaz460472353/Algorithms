package tree;

/**
 * 基础：二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        //1、创建节点
        //根节点-->10
        TreeNode treeNode1 = new TreeNode(10);
        //左孩子-->9
        TreeNode treeNode2 = new TreeNode(9);
        //右孩子-->20
        TreeNode treeNode3 = new TreeNode(20);
        //20的左孩子-->15
        TreeNode treeNode4 = new TreeNode(15);
        //20的右孩子-->35
        TreeNode treeNode5 = new TreeNode(35);

        //2、将节点串联起来
        //根节点的左右孩子
        treeNode1.setLeftNode(treeNode2);
        treeNode1.setRightNode(treeNode3);
        //20节点的左右孩子
        treeNode3.setLeftNode(treeNode4);
        treeNode3.setRightNode(treeNode5);

        //先序遍历树
        preTraverseBTree(treeNode1);
        //中序遍历树
        midTraverseBTree(treeNode1);
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
}
