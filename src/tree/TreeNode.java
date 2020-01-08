package tree;

/**
 * 基础：创建节点
 */
public class TreeNode {
    //左节点(儿子)
    private TreeNode leftNode;
    //右节点(儿子)
    private TreeNode rightNode;
    //数据
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
