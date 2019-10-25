import java.util.Arrays;

/**
 * Created by 79300 on 2019/10/25.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return;
        int idx = nums.length-2;

        while(idx>=0&&nums[idx]>=nums[idx+1]){
            idx--;
        }
        if(idx==-1) Arrays.sort(nums);
        else{
            int largerIdx = idx+1;
            while(largerIdx<nums.length&&nums[largerIdx]>nums[idx]){
                largerIdx++;
            }
            int temp = nums[idx];
            nums[idx] = nums[largerIdx-1];
            nums[largerIdx-1] = temp;
            Arrays.sort(nums,idx+1,nums.length);
        }
    }
}
