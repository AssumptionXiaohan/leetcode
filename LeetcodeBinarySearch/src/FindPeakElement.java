/**
 * Created by 79300 on 2019/10/7.
 * 比较mid和mid+1，画一个山峰图就很容易看出来，mid<mid+1的时候，peek在右边，反之在左边
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int mid_2 = mid + 1;
            if (nums[mid] < nums[mid_2]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return nums[low] > nums[high] ? low : high;
    }
}
