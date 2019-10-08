/**
 * Created by 79300 on 2019/10/7.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid;
            } else if (nums[mid] == nums[high]) {
                high--;
            } else {
                high = mid;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
