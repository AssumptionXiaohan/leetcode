/**
 * Created by 79300 on 2019/10/26.
 */
public class CountOfRangeSum {
    private int result = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        //sums[i] : nums[0]到nums[i-1]的和
        //sums[j]-sums[i] : nums[i]到nums[j-1]的和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        mergesort(sums, 0, sums.length - 1, lower, upper);
        return result;
    }

    private void mergesort(int[] nums, int low, int high, int lower, int upper) {
        if (low == high) return;
        int mid = low + (high - low) / 2;
        //left
        mergesort(nums, low, mid, lower, upper);
        //right
        mergesort(nums, mid + 1, high, lower, upper);
        //Record result
        //对左半部分遍历，在右半部分找到sums[right]-sums[left]属于[lower,upper]的right的两个端点
        //right1表示第一个满足条件的，right2表示最后一个满足条件的后一位
        //result += right2-right1;
        int right1 = mid + 1, right2 = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right1 <= high && nums[right1] - nums[left] < lower) {
                right1++;
            }
            right2 = right1;
            while (right2 <= high && nums[right2] - nums[left] <= upper) {
                right2++;
            }
            result = result + right2 - right1;
        }
        //Merge
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        //不可以修改low和high的值，后面copy会用到
        int left = low;
        int right = mid + 1;
        int i = 0;
        //当两边都还有值的时候 把较小的值加入temp[]
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[i] = nums[left];
                left++;
            } else {
                temp[i] = nums[right];
                right++;
            }
            i++;
        }
        //最后可能某一边没有走完，全部加入temp
        while (left <= mid) {
            temp[i] = nums[left];
            left++;
            i++;
        }
        while (right <= high) {
            temp[i] = nums[right];
            right++;
            i++;
        }
        //copy to the origin array
        for (int j = low; j <= high; j++) {
            nums[j] = temp[j - low];
        }
    }

    public static void main(String[] args) {
        CountOfRangeSum cr = new CountOfRangeSum();
        cr.countRangeSum(new int[]{-2, 5, -1}, -2, 2);
    }
}
