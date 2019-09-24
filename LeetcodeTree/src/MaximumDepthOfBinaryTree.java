/**
 * Created by 79300 on 2019/9/24.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    public int helper(TreeNode treeNode, int depth) {
        int left = 1, right = 1;
        if (treeNode.left == null && treeNode.right == null) return depth;
        if (treeNode.left != null) left = helper(treeNode.left, depth + 1);
        if (treeNode.right != null) right = helper(treeNode.right, depth + 1);
        return Math.max(left,right);
    }
}
