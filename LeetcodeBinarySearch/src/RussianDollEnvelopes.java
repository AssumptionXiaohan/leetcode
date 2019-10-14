import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by 79300 on 2019/10/12.
 * LonggestIncreasingSubsequence好像有点类似
 * 按width从小到大sort之后，求最大递增的sequence就可以
 * PS:如果width相等的话 要把height从大到小sort,因为6,7装不下6,4
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        int[] dp = new int[envelopes.length];
        int length = 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            }
        });
        dp[0] = envelopes[0][1];
        for (int i = 1; i < envelopes.length; i++) {
            if(envelopes[i][1]>dp[length]){
                length++;
                dp[length] = envelopes[i][1];
            } else if (envelopes[i][1] < dp[length]) {
                dp[binarySearch(0,length,dp,envelopes[i][1])] = envelopes[i][1];
            }
        }
        return length+1;
    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) high = mid;
            else if (target > nums[mid]) low = mid;
            else return mid;
        }
        if (target <= nums[low]) return low;
        if (target > nums[low] && target <= nums[high]) return high;
        if (target >= nums[high]) return high + 1;
        return -1;
    }
}
