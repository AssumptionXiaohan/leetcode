/**
 * Created by 79300 on 2019/7/2.
 * 要求把所有0都移到数组后面去
 * 可以先用一个left指针表示左边填入的位置
 * 遍历一遍把所以非0的都从left位置填进去，剩下的地方全填0就可以
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            }
        }
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}
