import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 79300 on 2019/9/20.
 */
public class BinaryTreePostorderTraversal {
/*  递归解法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);
        return lst;
    }

    private void helper(TreeNode node, List<Integer> lst) {
        if (node == null) return;
        if (node.left != null) helper(node.left, lst);
        if (node.right != null) helper(node.right, lst);
        lst.add(node.val);
    }*/

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> lst = new LinkedList<>();
        if (root == null) return lst;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        stack.push(p);
        //中左右->右左中
        while (!stack.empty()) {
            p = stack.pop();
            lst.addFirst(p.val);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
        return lst;
    }
}
