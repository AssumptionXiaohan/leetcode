import java.util.Stack;

/**
 * Created by 79300 on 2019/9/26.
 * 主要思想还是inorder traversal
 * 在遍历的过程中需要一个treenode记录上一个结点，因为是中序遍历，每次遍历到的新节点都需要比上次的结点大
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean helper(TreeNode node, long max, long min) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return helper(node.left, node.val, min) && helper(node.right, max, node.val);
    }

/*  iteration
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (pre != null && current.val <= pre.val) return false;
            pre = current;
            current = current.right;
        }
        return true;
    }*/

}
