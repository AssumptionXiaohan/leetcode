import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 79300 on 2019/9/19.
 */
public class BinaryTreePreorderTraversal {

/*  递归解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root,lst);
        return lst;
    }

    private void helper(TreeNode node, List<Integer> lst){
        if(node==null) return;
        lst.add(node.val);
        if(node.left!=null) helper(node.left,lst);
        if(node.right!=null) helper(node.right,lst);
    }*/

    //先一直往左走，走到null就从栈里push出一个往右找一步，再接着重复之前的步骤
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t = stack.pop();
            lst.add(t.val);
            if (t.right != null) stack.push(t.right);
            if (t.left != null) stack.push(t.left);
        }
        return lst;
    }

}
