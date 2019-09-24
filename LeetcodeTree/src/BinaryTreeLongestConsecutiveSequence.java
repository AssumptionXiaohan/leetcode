/**
 * Created by 79300 on 2019/9/23.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    public int helper(TreeNode treeNode, int length) {
        int left = 1, right = 1;
        if (treeNode.left == null && treeNode.right == null) return length;
        if (treeNode.left != null) {
            if (treeNode.left.val == treeNode.val + 1) {
                //一定要记得和现在的length比较取大的值
                left = Math.max(length,helper(treeNode.left, length + 1));
            } else {
                left = Math.max(length,helper(treeNode.left, 1));
            }
        }
        if (treeNode.right != null) {
            if (treeNode.right.val == treeNode.val + 1) {
                right = Math.max(length,helper(treeNode.right, length + 1));
            } else {
                right = Math.max(length,helper(treeNode.right, 1));
            }
        }
        return Math.max(left, right);
    }

}
