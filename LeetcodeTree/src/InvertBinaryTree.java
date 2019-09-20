/**
 * Created by 79300 on 2019/9/20.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
