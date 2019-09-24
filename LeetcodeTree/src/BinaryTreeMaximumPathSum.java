/**
 * Created by 79300 on 2019/9/24.
 * maxSum的值变化和return的子树最大值是要分开的
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode treeNode) {
        if (treeNode == null) return 0;
        //left表示该节点的左子结点的sum最大的路径，right同理
        //如果两个子结点sum最大的时候<0，不如不加
        int left = Math.max(helper(treeNode.left), 0);
        int right = Math.max(helper(treeNode.right), 0);
        //更新maxSum的值，
        maxSum = Math.max(maxSum, left + right + treeNode.val);
        //return当前当前子结点的sum最大的路径，也就是当前结点的值加上左右相比较大的一条路径
        return Math.max(left,right)+treeNode.val;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(-2);
        TreeNode t2 = new TreeNode(1);
        t.left = t2;
        BinaryTreeMaximumPathSum bt  = new BinaryTreeMaximumPathSum();
        System.out.println(bt.maxPathSum(t));
    }
}
