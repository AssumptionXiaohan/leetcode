/**
 * Created by 79300 on 2019/7/2.
 * greedy AL
 * 只要找到所有封底和峰谷的个数，加起来就可以
 * 因为可以先递增也可以先递减，所以用一个flag表示状态
 * flag=1表示找biggernumber，flag=-1表示在找lowernumber
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int maxlength = 1;
        //flag一开始为0因为不能确认是递增还是递减，下面两个if判断都能进去
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && flag != -1) {
                maxlength++;
                flag = -1;
            } else if (nums[i] < nums[i - 1] && flag != 1) {
                maxlength++;
                flag = 1;
            }
        }
        return maxlength;
    }
}
