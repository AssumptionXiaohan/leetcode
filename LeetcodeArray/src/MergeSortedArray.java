/**
 * Created by 79300 on 2019/7/1.
 * 这题不能用一个多余的数组来把nums1和nums2数组里小的数放进去
 * 但nums1有多余的空间
 * 所以我们可以从nums1的最后一个位置开始填进去
 * 另外两个指针也分别从两个数组的尾部开始比较，把最大的值填入nums1的尾部
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_idx = m - 1, nums2_idx = n - 1, next_position = m + n - 1;
        while (nums1_idx >= 0 && nums2_idx >= 0) {
            if (nums2[nums2_idx] >= nums1[nums1_idx]) {
                nums1[next_position] = nums2[nums2_idx];
                nums2_idx--;
                next_position--;
            } else {
                nums1[next_position] = nums1[nums1_idx];
                nums1_idx--;
                next_position--;
            }
        }
        //跳出while循环之后可能存在nums2还没有填完的情况
        while (nums2_idx >= 0) {
            nums1[next_position] = nums2[nums2_idx];
            nums2_idx--;
            next_position--;
        }
    }

}
