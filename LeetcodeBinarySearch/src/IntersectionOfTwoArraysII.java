import java.util.*;

/**
 * Created by 79300 on 2019/10/8.
 * 用hashmap记录在nums1里的数字和出现次数，nums2里每出现一次相同的元素就加到结果集，同时出现次数-1
 * Time complexity O(m+n) Space O(m)
 * follow-up:
 * 1.如果是sorted就用two pointer
 * 2.two pointer O(max(m,n)) space O(1)
 * If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
 * <p>
 * If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 chunks from each array at a time in memory, record intersections.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            if (hashmap.containsKey(num)) {
                hashmap.put(num, hashmap.get(num) + 1);
            }else {
                hashmap.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (hashmap.containsKey(num) && hashmap.get(num) > 0) {
                result.add(num);
                hashmap.put(num, hashmap.get(num) - 1);
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
    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,1};
        int[] b = new int[]{2,2};
        IntersectionOfTwoArraysII inter = new IntersectionOfTwoArraysII();
        for (int num : inter.intersect(a, b)) {
            System.out.println(num);
        }
    }
}
