import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/22.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0, sum, result, lst);
        return result;
    }

    public void helper(TreeNode root, int current, int sum, List<List<Integer>> result, List<Integer> current_list) {
        //到叶子结点且所有的和等于sum时加入结果集
        if (root.left == null && root.right == null && root.val + current == sum) {
            current_list.add(root.val);
            result.add(current_list);
        }
        if (root.left != null) {
            //不能改变current_list的值，因为可能后面的递归也要用到current_list，所以需要new一个新的list
            List<Integer> new_list = new ArrayList<>(current_list);
            new_list.add(root.val);
            helper(root.left, current + root.val, sum, result, new_list);
        }
        if (root.right != null) {
            List<Integer> new_list = new ArrayList<>(current_list);
            new_list.add(root.val);
            helper(root.right, current + root.val, sum, result, new_list);
        }
    }
}
