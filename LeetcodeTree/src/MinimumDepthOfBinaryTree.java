/**
 * Created by 79300 on 2019/9/23.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    public int helper(TreeNode treeNode, int depth) {
        int left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        if (treeNode.left == null && treeNode.right == null) return depth;
        if (treeNode.left != null) left = helper(treeNode.left, depth + 1);
        if (treeNode.right != null) right = helper(treeNode.right, depth + 1);
        return Math.min(left,right);
    }
}
