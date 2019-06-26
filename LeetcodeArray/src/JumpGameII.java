/**
 * Created by 79300 on 2019/6/26.
 * 这题是真的很难，篮子王的讲解很不错 如果忘记了的话
 * https://www.youtube.com/watch?v=r3pZd9ghqxk
 */
public class JumpGameII {
    //[2,1,3,1,1,1,1]
    public int jump(int[] nums) {
        //这里是因为测试用例里有一个[0]，如果按照正常套路的话计算出来是走一步能到结尾，但其实一开始就在结尾了
        if(nums.length==1) return 0;
        //next_max是下一步能走到的最远位置，current_max是当前能走到的最远位置
        //当i已经到current_max的时候，步数+1，同时把next_max赋给current_max，也就算是到达新起点了
        //接着也不断更新next_max值，找到能走到的下一步最远的地方
        //一直到current_max已经超过数组长度就可以结束了，说明现在已经可以跳到数组末端了
        int next_max = 0, current_max = 0, jumps = 0;
        for (int i = 0; i < nums.length; i++) {
            next_max = Math.max(next_max, i + nums[i]);
            if (i == current_max) {
                jumps++;
                current_max = next_max;
                if (current_max >= nums.length - 1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{0}));
    }
}
