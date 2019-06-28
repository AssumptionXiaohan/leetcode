/**
 * Created by 79300 on 2019/6/29.
 * 按道理可以用放在正确的位置的方法 但是题目给了not modify array。。
 * ------下面是新方法---------
 *
 */
public class FindTheDuplicateNumber {
    
/*    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) return nums[i];
                else {
                    swap(nums, i, nums[i] - 1);
                }
            }else {
                i++;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }*/

    public static void main(String[] args) {
        FindTheDuplicateNumber fdn = new FindTheDuplicateNumber();
        System.out.println(fdn.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
