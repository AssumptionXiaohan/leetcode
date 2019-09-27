import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/25.
 * 叶子结点的height是0，非叶子结点的height是Math.max(height(node.left),height(node.right))+1
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result);
        return result;
    }

    //返回当前结点的height - 距离叶子结点的最短距离
    public int helper(TreeNode treeNode, List<List<Integer>> result) {
        if (treeNode == null) return -1;
        int height = Math.max(helper(treeNode.left, result), helper(treeNode.right, result)) + 1;
        if (result.size() == height) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(treeNode.val);
        return height;
    }
}
