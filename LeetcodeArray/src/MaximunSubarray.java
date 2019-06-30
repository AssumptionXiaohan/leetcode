/**
 * Created by 79300 on 2019/6/30.
 * 这也是一个动态规划的问题DP!!
 * 要想到的状态是：maxSum[i]:在0到i之间和最大的子区间
 * 要返回的值是：maxSum[0,1,2...n-1]里最大的一个
 */
public class MaximunSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int maxSum = 0, maxSumGlobal = Integer.MIN_VALUE, i = 0, negative = Integer.MIN_VALUE;
        while (nums[i] <= 0) {
            negative = Math.max(negative, nums[i]);
            if (i == nums.length - 1) return negative;
            i++;
        }

        for (; i < nums.length; i++) {
            //要么是之前的区间+nums[i]，要么是从nums[i]重新开始
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            //这里其实相当于找到是哪一个i的时候取到最大值，也就是在maxSum[0]到maxSum[n-1]中找最大值
            //如果是到结尾的子区间，返回maxSum就可以了，但区间可以在任何地方结束所以要记录一个global的最大值
            maxSumGlobal = Math.max(maxSumGlobal,maxSum);
        }
        return maxSumGlobal;
    }

    public static void main(String[] args) {
        MaximunSubarray ms = new MaximunSubarray();
        ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}