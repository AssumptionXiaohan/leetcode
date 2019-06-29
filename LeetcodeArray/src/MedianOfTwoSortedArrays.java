/**
 * Created by 79300 on 2019/6/29.
 * 把两个数组分为两个部分，首先让两个数组划分的左边部分加起来数量=m+n+1/2
 * 如果总长度是偶数，那么两个中位数一个是左部分最大值，一个是右部分最小值，加起来平均即可
 * 如果总长度是奇数，那么分子上+1的操作把中位数保留在了左部分，求左部分最大值即可
 * <p>
 * 要保证两个数组一起来看，左边部分的值永远小于右边部分的值
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //默认nums1长度小，在nums1上做二分查找，如果nums1长度比nums2长，重新调用一次函数把参数反过来
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        //nums1如果是空数组
        if (nums1.length == 0) return findArrayMedium(nums2);

        int length = (nums1.length + nums2.length + 1) / 2;
        int nums1_left = 0, nums1_right = nums1.length - 1, num1_mid, nums2_idx;
        while (nums1_left <= nums1_right) {
            num1_mid = (nums1_left + nums1_right) / 2;
            nums2_idx = length - num1_mid - 2;
            if (nums1[num1_mid] > nums2[nums2_idx + 1]) {
                //第一个数组的左边最大值大于第二个数组右边最小值，说明这个数太大了要往左边挪
                nums1_right = num1_mid - 1;
            } else if (num1_mid != nums1.length - 1 && nums2[nums2_idx] > nums1[num1_mid + 1]) {
                //第二个数组的左边最大值大于第一个数组右边最小值，说明第一个数组现在的位置的数太小了要往右边挪
                //要处理一下这个时候第一个数组右边可能没有值了，被拉满了
                nums1_left = num1_mid + 1;
            } else {
                //现在是满足条件的情况
                double left_max;
                //nums2_idx可能等于-1如果nums1所有的元素都小于nums2的元素
                if (nums2_idx != -1) left_max = Math.max(nums1[num1_mid], nums2[nums2_idx]);
                else left_max = nums1[num1_mid];

                double right_min;
                //防止+1之后index out of range 因为nums1可能被拉满了
                if (num1_mid != nums1.length - 1) right_min = Math.min(nums1[num1_mid + 1], nums2[nums2_idx + 1]);
                else right_min = nums2[nums2_idx + 1];

                if (nums1.length + nums2.length % 2 == 1) {
                    //假设总长度是奇数，中位数是两个数的左部分最大值
                    return left_max;
                } else {
                    //偶数的话要做一个平均
                    return (left_max + right_min) / 2;
                }
            }
        }
        return -1;
    }

    private double findArrayMedium(int nums[]) {
        if (nums.length == 0) return -1;
        if (nums.length % 2 == 1) return nums[nums.length / 2];
        else {
            double left = nums[nums.length / 2];
            double right = nums[nums.length / 2 - 1];
            return (left + right) / 2;
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays msa = new MedianOfTwoSortedArrays();
        System.out.println(msa.findMedianSortedArrays(new int[]{3}, new int[]{1,2}));
    }
}
