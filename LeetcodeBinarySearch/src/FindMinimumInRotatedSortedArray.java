/**
 * Created by 79300 on 2019/10/7.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]){
                low = mid;
            }else {
                high = mid;
            }
        }
        return Math.min(nums[low],nums[high]);
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fs = new FindMinimumInRotatedSortedArray();
        System.out.println(fs.findMin(new int[]{3,4,5,1,2}));
    }

}
