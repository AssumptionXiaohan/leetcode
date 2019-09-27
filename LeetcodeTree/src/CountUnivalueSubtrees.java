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


}
