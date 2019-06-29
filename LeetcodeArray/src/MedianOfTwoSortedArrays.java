/**
 * Created by 79300 on 2019/6/29.
 * 把两个数组分为两个部分，首先让两个数组划分的左边部分加起来数量=m+n+1/2
 * 如果总长度是偶数，那么两个中位数一个是左部分最大值，一个是右部分最小值，加起来平均即可
 * 如果总长度是奇数，那么分子上+1的操作把中位数保留在了左部分，求左部分最大值即可
 * <p>
 * 要保证两个数组一起来看，左边部分的值永远小于右边部分的值
 */
public class MedianOfTwoSortedArrays {
/*    public double medianOfTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return medianOfTwoSortedArray(nums2, nums1);
        if (nums1.length == 0) return medianOfSortedArray(nums2);
        int start = 0, end = nums1.length;
        // partitonsOfAll 表示的意思和你的length表示的意思一样 左半部分元素的个数
        int partitionsOfAll = (nums1.length + nums2.length + 1) / 2;
        // partitionsNums1 表示nums1在partitionsOfAll中的元素个数
        // partitionsNums2 表示nums2在partitionsOfAll中的元素个数
        int partitionNums1, partitionNums2;

        while (start <= end) {
            partitionNums1 = (start + end) / 2; //相当于mid
            //元素总个数减去nums1左半部分的元素个数
            partitionNums2 = partitionsOfAll - partitionNums1;
            // nums1LeftPartMax表示nums1中左半部分最大的元素，如果partitionNums1为0说明partitionsOfAll全在nums2，
            // 这时候设置为Integer最小值
            // 同理 nums1RightPartMin表示nums1中右半部分最小的元素，如果partitionNums1为nums1.length，说明右半部分为空了，
            // 这时候设置为Integer最大值
            // nums2LeftPartMax和nums2RightPartMin同理可得
            int nums1LeftPartMax = partitionNums1 == 0 ? Integer.MIN_VALUE : nums1[partitionNums1 - 1];
            int nums2LeftPartMax = partitionNums2 == 0 ? Integer.MIN_VALUE : nums2[partitionNums2 - 1];
            int nums1RightPartMin = partitionNums1 == nums1.length ? Integer.MAX_VALUE : nums1[partitionNums1];
            int nums2RightPartMin = partitionNums2 == nums2.length ? Integer.MAX_VALUE : nums2[partitionNums2];

            //这里nums1左半部分的最大值必须<=nums2右半部分最小值，
            // nums2左半部分的最大值必须<=nums1右半部分的最小值，
            // 如果nums1LeftPartMax>nums2RightPartMin 意味着右指针要向左移，因为nums1左半部分的元素过多了
            // 如果nums2LeftPartMax>nums1RightPartMin 意味着左指针要向右移
            if (nums1LeftPartMax <= nums2RightPartMin && nums2LeftPartMax <= nums1RightPartMin) {
                if ((nums1.length + nums2.length) % 2 == 1) return Math.max(nums1LeftPartMax, nums2LeftPartMax);
                else return ((double) Math.max(nums1LeftPartMax, nums2LeftPartMax) +
                        (double) Math.min(nums1RightPartMin, nums2RightPartMin)) / 2;
            } else if (nums1LeftPartMax > nums2RightPartMin) {
                end = partitionNums1 - 1;
            } else {
                start = partitionNums1 + 1;
            }
        }
        return -1;
    }*/


    private double medianOfSortedArray(int[] nums) {
        return nums.length % 2 == 1 ? nums[nums.length / 2] : ((double) nums[nums.length / 2] + (double) nums[nums.length / 2 - 1]) / 2;
    }

/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //默认nums1长度小，在nums1上做二分查找，如果nums1长度比nums2长，重新调用一次函数把参数反过来
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        if (nums1.length == 0) return findArrayMedium(nums2);

        //length表示左边部分总元素的个数
        int length = (nums1.length + nums2.length + 1) / 2;
        int nums1_left = 0, nums1_right = nums1.length - 1, num1_mid = 0, nums2_idx = 0;
        while (nums1_left <= nums1_right) {
            num1_mid = nums1_left + (nums1_right - nums1_left) / 2;
            nums2_idx = length - num1_mid - 2;
            if (nums2_idx < 0) break;
            if (nums1[num1_mid] > nums2[nums2_idx + 1]) {
                //第一个数组的左边最大值大于第二个数组右边最小值，说明这个数太大了要往左边挪
                nums1_right = num1_mid - 1;
            } else if (num1_mid + 1 >= nums1.length) {
                break;
            } else if (nums2[nums2_idx] > nums1[num1_mid + 1]) {
                //第二个数组的左边最大值大于第一个数组右边最小值，说明第一个数组现在的位置的数太小了要往右边挪
                nums1_left = num1_mid + 1;
            } else {
                break;
            }
        }

        //开始找到中位数
        double left_max = 0, right_min = 0;
        //right<0(=-1)，说明左部分全部在nums2里,nums2_idx<0说明左部分全部在nums1里，
        if (nums1_right < 0) {
            nums2_idx++; //这一步是因为之前nums_right往左挪变成-1时，nums2_idx没有往后挪
            left_max = nums2[nums2_idx];
            right_min = nums2_idx + 1 < nums2.length ? Math.min(nums1[0], nums2[nums2_idx + 1]) : nums1[0];
        } else if (nums2_idx < 0) {
            //左部分最大值就是nums1的最大值，右部分最小值就是nums2最小值
            left_max = nums1[num1_mid];
            right_min = num1_mid + 1 < nums1.length ? Math.min(nums2[0], nums1[num1_mid + 1]) : nums2[0];
        } else {
            left_max = Math.max(nums1[num1_mid], nums2[nums2_idx]);
            right_min = num1_mid + 1 < nums1.length ? Math.min(nums1[num1_mid + 1], nums2[nums2_idx + 1]) : nums2[nums2_idx + 1];
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            //假设总长度是奇数，中位数是两个数的左部分最大值
            return left_max;
        } else {
            //偶数的话要做一个平均
            return (left_max + right_min) / 2;
        }
    }

    private double findArrayMedium(int nums[]) {
        if (nums.length == 0) return -1;
        if (nums.length % 2 == 1) return nums[nums.length / 2];
        else {
            double left = nums[nums.length / 2];
            double right = nums[nums.length / 2 - 1];
            return (left + right) / 2;
        }
    }*/
}
