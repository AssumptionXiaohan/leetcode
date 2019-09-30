import java.util.Stack;

/**
 * Created by 79300 on 2019/9/29.
 * 中序遍历，用一个pre表示当前结点的上一个结点
 * 当pre为p的时候返回当前结点，也就是p的后续结点(in order successor)
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (pre != null && pre.val == p.val) return current;
            pre = current;
            current = current.right;
        }
        return null;
    }
}
