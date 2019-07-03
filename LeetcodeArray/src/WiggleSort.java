/**
 * Created by 79300 on 2019/7/2.
 * 不断重复增加、减小、增加、减小的序列
 * 如果不满足条件的话直接和后面一个换一下就可以了
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = 0; i < nums.length - 1; i++) {
            //index为0、2、4、6、8..的数需要满足的条件
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            } else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
