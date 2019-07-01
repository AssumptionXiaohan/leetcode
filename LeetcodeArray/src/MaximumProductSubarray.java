/**
 * Created by 79300 on 2019/7/1.
 * 这题也是一个DP问题
 * 有趣的是要找的状态除了local_max[i]和global_max[i]，还需要local_min[i]
 * 因为考虑到如果当前的元素是负数的话，乘前面最小的值才最大
 * 所以要保存和随时更新一个到目前为止的区间乘积最小值
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int local_max = nums[0], local_min = nums[0], global_max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                local_max = Math.max(nums[i], local_max * nums[i]);
                local_min = Math.min(nums[i], local_min * nums[i]);
            } else {
                //这里因为同时需要用到上一次的local_max和上一次的local_min所以需要一个临时存储变量
                int temp = local_max;
                local_max = Math.max(nums[i], local_min * nums[i]);
                local_min = Math.min(nums[i], temp * nums[i]);
            }
            global_max = Math.max(global_max, local_max);
        }
        //这里的边界条件很重要。。因为后面乘来乘去可能也没有第一个元素本身大
        if (global_max < nums[0]) return nums[0];
        return global_max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray mps = new MaximumProductSubarray();
        System.out.println(mps.maxProduct(new int[]{-4, -3, -2}));
    }
}
