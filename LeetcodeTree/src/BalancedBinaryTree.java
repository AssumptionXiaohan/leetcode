/**
 * Created by 79300 on 2019/9/24.
 * 递归需要传出两个信息：一个boolean判断左右子树是不是平衡二叉树，一个depth判断左右子树的depth
 * 但是函数只能有一个类型的返回值，所以我们用-1代表某个数不是平衡二叉树，因为depth的范围是>=0的
 * https://www.youtube.com/watch?v=Be5CUodZliM
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = helper(treeNode.left);
        int right = helper(treeNode.right);
        //当左右两个子树有一个不为平衡二叉树，或者两个树高度绝对值差大于1的时候，现在的树不是平衡二叉树，返回-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        //现在的树是平衡二叉树，返回新的高度
        else return Math.max(left, right) + 1;
    }

}
