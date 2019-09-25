/**
 * Created by 79300 on 2019/9/24.
 */
public class CountUnivalueSubtrees {
    private int count;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return count;
    }

    //返回以该节点为根节点的子树是否是uni-value subtree
    public boolean helper(TreeNode treeNode) {
        if (treeNode == null) return true;
        if (treeNode.left == null && treeNode.right == null) {
            count++;
            return true;
        }
        boolean left = helper(treeNode.left);
        boolean right = helper(treeNode.right);

        //只有右子树
        if (treeNode.left == null) {
            if (right && treeNode.right.val == treeNode.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
        //只有左子树
        else if (treeNode.right == null) {
            if (left && treeNode.left.val == treeNode.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
        //左右子树都有
        else {
            if (left && right && treeNode.left.val == treeNode.val && treeNode.val == treeNode.right.val) {
                count++;
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        CountUnivalueSubtrees ss = new CountUnivalueSubtrees();
        System.out.println(ss.countUnivalSubtrees(n1));
    }
}
