/**
 * Created by 79300 on 2019/6/26.
 * 这题的solution写的特别好 可以看一下https://leetcode.com/problems/jump-game/solution/
 * 从后往前看，数组的最后一个元素肯定是可以跳到结尾的，因为结尾就是它本身
 * 然后看倒数第二个，如果倒数第二个元素的值>=1的话 也是可以跳到最后一个的
 * 这样一直往前，用一个can_jump的值记录最近一次找到的能跳到数组末尾的点
 * 假设其中的某一个点能跳到最近一次找到的can_jump点，那么这个点就是新的can_jump点
 * 如果最后到了数组的第一位也是can_jump，就说明数组第一位开始跳可以跳到结尾
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int can_jump = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--){
            if(nums[i]+i>=can_jump){
                can_jump = i;
            }
        }
        /*if(can_jump==0) return true;
        else return false;*/
        return can_jump==0;
    }
}
