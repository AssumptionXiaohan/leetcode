import java.util.Arrays;

/**
 * Created by 79300 on 2019/10/8.
 * DP问题
 * 维持一个dp的数组，dp[i]表示到i位置最大的递增序列，初始值全为1
 * 对每一个nums[i],遍历从0到i的值，如果有比nums[i]小的值，更新dp[i]
 * <p>
 * 二分查找+dp
 * dp的数组初始化为0，维护一个tail指在dp的最后一个非0数字，如果num[i]>dp[tail]的话，直接加到dp数组里，tail++
 * 如果num[i]<dp[tail]的话，binary search数组dp的0到tail，找到num[i]应该插入的位置，把那个位置的值替换为num[i]
 */
public class LongestIncreasingSubsequence {
    /*    public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int[] dp = new int[nums.length];
            int ans = 1;
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        ans = Math.max(dp[i], ans);
                    }
                }
            }
            return ans;
        }*/
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int length = 0;
        dp[length] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[length]) {
                length++;
                dp[length] = nums[i];
            } else if (nums[i] < dp[length]) {
                dp[binarySearch(0, length, dp,nums[i])] = nums[i];
            }
        }
        return length+1;
    }

    private int binarySearch(int low, int high, int[] nums,int target) {
        while (low + 1 < high) {
            int mid = low + (high-low)/2;
            if(target<nums[mid]) high = mid;
            else if(target>nums[mid]) low = mid;
            else return mid;
        }
        if(target<=nums[low]) return low;
        if(target>nums[low]&&target<=nums[high]) return high;
        if(target>=nums[high]) return high+1;
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{10,9,2,5,3,4};
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        System.out.println(ls.lengthOfLIS(test));
    }
}
