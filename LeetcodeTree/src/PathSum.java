/**
 * Created by 79300 on 2019/9/22.
 * 递归
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return helper(root, 0, sum);
    }

    public boolean helper(TreeNode root, int current, int sum) {
        if (root.left == null && root.right == null) return current + root.val == sum;
        //这里需要用2个boolean值的或关系来判断，否则一条路径return false之后就不再判断下一条了
        boolean left = false, right = false;
        if (root.left != null) left = helper(root.left, current + root.val, sum);
        if (root.right != null) right = helper(root.right, current + root.val, sum);
        return left || right;
    }
}
