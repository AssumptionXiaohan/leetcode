import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/17.
 */
public class RemoveDuplicateII {
    public int removeDuplicatesII(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0;
        //双指针法，i代表下一个填入的位置，j代表遍历到的位置，当j遍历到数组末尾时结束
        while (j < nums.length) {
            //先把当前的值存到i位置，并设置appear_count为一次
            int current_value = nums[j], appear_count = 1;
            nums[i] = current_value;
            i++;
            //当j与当前值相等时，j往后移。即跳过重复的元素
            while (j < nums.length && nums[j] == current_value) {
                j++;
                //如果元素是第一次出现重复，填入i的位置并修改i的值。多次重复不再填入i的位置。
                if (i < nums.length && j < nums.length && nums[j] == current_value && appear_count < 2) {
                    nums[i] = current_value;
                    appear_count++;
                    i++;
                }
            }
        }
        return i - 1;
/*
        if (nums.length == 0) return 0;
        int i = 0, j = 0;
        int current_value = nums[j],appear_count=0;
        while (j < nums.length) {
            if(nums[j] ==current_value){
                j++;
                appear_count++;
                if(appear_count<=2){
                    nums[i]=current_value;
                    i++;
                }
                continue;
            }
            current_value = nums[j];
            appear_count =0;
        }
        System.out.println(Arrays.toString(nums));
        return i;*/
    }

    public static void main(String[] args) {
        RemoveDuplicateII rd = new RemoveDuplicateII();
        System.out.println(rd.removeDuplicatesII(new int[]{0, 0, 1, 1, 2, 3, 3}));
    }
}
