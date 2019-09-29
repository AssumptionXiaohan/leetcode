/**
 * Created by 79300 on 2019/9/28.
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //说明p和q在左右两边的子树上，LCA就是root了
        if (left != null && right != null) return root;
        else if(left!=null) return left;
        else if(right!=null) return right;
        //说明没有找到p、q
        else return null;
    }
}
