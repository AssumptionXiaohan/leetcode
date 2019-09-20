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
        TreeNode p = root;
        List<Integer> lst = new ArrayList<>();
        if (p == null) return lst;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.empty()){
            if (p!=null){
                lst.add(p.val);
                stack.push(p);
                p = p.left;
            }else {
                p = stack.peek();
                stack.pop();
                p = p.right;
            }
        }
        return lst;
    }

}
