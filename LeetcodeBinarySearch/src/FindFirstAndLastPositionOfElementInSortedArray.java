/**
 * Created by 79300 on 2019/10/8.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchInsert(nums, target - 0.5);
        result[1] = searchInsert(nums, target + 0.5);
        if (result[0] == result[1]) return new int[]{-1, -1};
        else {
            result[1] = result[1] - 1;
            return result;
        }
    }

    public int searchInsert(int[] nums, double target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (target <= nums[low]) return low;
        else if (target > nums[low] && target < nums[high]) return high;
        return high + 1;
    }
}
