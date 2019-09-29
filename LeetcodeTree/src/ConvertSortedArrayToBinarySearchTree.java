/**
 * Created by 79300 on 2019/9/28.
 * 递归
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode helper(int[] nums, int low, int high) {
        //有点类似二分法，把数组分成左边一半和右边一半，左子树和右子树
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
