import java.util.*;

/**
 * Created by 79300 on 2019/10/8.
 */
public class IntersectionOfTwoArraysII {
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
}
