import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 79300 on 2019/10/8.
 * 可以把长的那个数组sort了然后对短的里的所有元素，在长的有序数组里进行二分搜索。用hashset去掉重复元素
 * 这里也可以用两个hashset来实现
 */
public class IntersectionOfTwoArrays {
/*  2个hashset 98% 89% O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1_uniq = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            nums1_uniq.add(num);
        }
        for (int num : nums2) {
            if (nums1_uniq.contains(num)) {
                result.add(num);
            }
        }

        int[] result_array = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            result_array[i] = num;
            i++;
        }
        return result_array;
    }*/
    //二分法是36.88% 89% O(nlogn)
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length) return intersection(nums2,nums1);
        HashSet<Integer> result = new HashSet<>();
        Arrays.sort(nums2);
        for(int num:nums1){
            if(binarySearch(nums2,num)!=-1){
                result.add(num);
            }
        }
        int[] result_array = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            result_array[i] = num;
            i++;
        }
        return result_array;
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) low = mid;
            else high = mid;
        }
        if(nums[low]==target) return low;
        if(nums[high]==target) return high;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 5};
        int[] b = new int[]{9, 4, 9, 8, 4};
        IntersectionOfTwoArrays inter = new IntersectionOfTwoArrays();
        for (int num : inter.intersection(a, b)) {
            System.out.println(num);
        }
    }
}
