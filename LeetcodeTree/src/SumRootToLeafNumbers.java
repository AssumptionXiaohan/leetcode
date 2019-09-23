/**
 * Created by 79300 on 2019/9/22.
 * recursive
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode treeNode, int result) {
        //说明不存在该分支，return 0
        if (treeNode == null) return 0;
        //左右结点都为空说明访问到了末尾
        if (treeNode.left == null && treeNode.right == null) return result*10+treeNode.val;
        //左右结点至少有一个不为空，递归函数
        return helper(treeNode.left, result * 10 + treeNode.val) + helper(treeNode.right, result * 10 + treeNode.val);
    }

}
