
/**
 * Created by 79300 on 2019/9/28.
 * 二分查找，更新result的值即可
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - result)) {
                result = root.val;
            }
            if (target < root.val) root = root.left;
            else root = root.right;
        }
        return result;
    }
}
