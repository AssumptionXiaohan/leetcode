import java.util.Stack;

/**
 * Created by 79300 on 2019/9/20.
 * iteration & recursive
 */
public class SymmetricTree {
/*  recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left==null||right==null) return left==right;
        if(left.val!=right.val) return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }*/

    //iteration
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode p1 = stack.pop();
            TreeNode p2 = stack.pop();
            if (p1 == null || p2 == null) return p1 == p2;
            if (p1.val != p2.val) return false;
            stack.push(p1.left);
            stack.push(p2.right);
            stack.push(p1.right);
            stack.push(p2.left);
        }
        return true;
    }
}
