import java.util.Arrays;

/**
 * Created by 79300 on 2019/10/8.
 * DP问题
 * 维持一个dp的数组，dp[i]表示到i位置最大的递增序列，初始值全为1
 * 对每一个nums[i],遍历从0到i的值，如果有比nums[i]小的值，更新dp[i]
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
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
    }
}
