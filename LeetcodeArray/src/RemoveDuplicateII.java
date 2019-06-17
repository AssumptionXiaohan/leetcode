/**
 * Created by 79300 on 2019/6/17.
 */
public class RemoveDuplicateII {
    public int removeDuplicates(int[] nums) {
        int i = 0,j=0;
        while (j < nums.length) {
            int current_value = nums[j];
            nums[i] = current_value;
            i++;
            while (j < nums.length && nums[j] == current_value) j++;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicate rd = new RemoveDuplicate();
        System.out.println(rd.removeDuplicates(new int[]{1, 1, 2}));
    }
}
