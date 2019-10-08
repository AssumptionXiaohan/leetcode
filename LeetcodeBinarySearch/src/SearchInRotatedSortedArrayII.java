/**
 * Created by 79300 on 2019/10/7.
 * https://www.youtube.com/watch?v=eG27FBcmy1k
 * 存在重复的数字 可能出现mid=low=high的情况
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        //当low和high相邻的时候就终止了，不再计算mid
        //防止mid一直和low重合的循环
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[low]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else if (nums[mid] == nums[low]) {
                low++;
            } else {
                if (nums[high] >= target && target >= nums[mid]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        if (nums[low] == target || nums[high] == target) return true;
        return false;
    }
}
