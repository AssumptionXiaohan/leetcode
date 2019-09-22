import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/22.
 * recursive
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) helper(root, "", result);
        return result;
    }

    public void helper(TreeNode root, String path, List<String> result) {
        //每当到leaf node的时候加入当前的path进结果集
        if (root.left == null && root.right == null) result.add(path + root.val);
        //当左右结点不为空的时候加上当前结点的值，继续往下搜索
        if (root.left != null) helper(root.left, path + root.val + "->", result);
        if (root.right != null) helper(root.right, path + root.val + "->", result);
    }
}
