import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/16.
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        //双指针法，i代表下一个填入的位置，j代表遍历到的位置，当j遍历到数组末尾时结束
        while (j < nums.length) {
            //把当前的值存入i的位置
            int current_value = nums[j];
            nums[i] = current_value;
            i++;
            //把j不断后移，跳过相同的值
            while (j < nums.length && nums[j] == current_value) j++;
        }
        return i;
/*        if(nums.length==0) return 0 ;
        int i = 0,j=0;
        int current_value = nums[j];
        while (j < nums.length) {
            if(nums[j]==current_value){
                j++;
                continue;
            }
            current_value = nums[j];
            i++;
            nums[i] = current_value;
        }
        return i+1;*/
    }

    public static void main(String[] args) {
        RemoveDuplicate rd = new RemoveDuplicate();
        System.out.println(rd.removeDuplicates(new int[]{}));
    }
}
