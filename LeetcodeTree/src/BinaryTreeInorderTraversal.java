import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 79300 on 2019/9/19.
 */
public class BinaryTreeInorderTraversal {
    /*  递归解法
        public List<Integer> inorderTraversal(TreeNode root) {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.peek();
                stack.pop();
                lst.add(p.val);
                p = p.right;
            }
        }
        return lst;
    }
}
