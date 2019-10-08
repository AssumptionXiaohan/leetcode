/**
 * Created by 79300 on 2019/10/7.
 * low<=high最后的结果就会是low在high后面一位，return low就正好是需要插入的index
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
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
