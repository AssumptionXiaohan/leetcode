/**
 * Created by 79300 on 2019/7/1.
 * 这种求最小区间的题一般都要利用好sum[i],也就是从0加到i的和
 * 这题要用一个指针指在left的位置，当sum[i]>=s的时候，left就要往后移动到下一位了
 * 当然这题sum[i]要随着left指针往后移动减去之前的一些值
 * 原理有点类似滑动窗口
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, left = 0, min_length = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            //当sum>=s的时候不断更新left的值
            while (sum >= s) {
                min_length = Math.min(min_length, i - left + 1);
                sum = sum - nums[left];//这个时候sum就要减去left位置的值了，因为left要更新+1了
                left++;
            }
        }
        if (min_length != Integer.MAX_VALUE) return min_length;
        else return 0;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
        System.out.println(ms.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
