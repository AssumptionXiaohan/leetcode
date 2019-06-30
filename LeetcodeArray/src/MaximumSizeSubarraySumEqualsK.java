import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79300 on 2019/7/1.
 * 这题主要是用hashmap 把i之前所有元素的sum作为key，i作为value
 * 这样两个key相减=k的说明两个index之间的元素加起来=k
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int key = 0, max_length = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            key = key + nums[i];
            //假设从左到右加到了等于k的时候，更新max
            //这一句也可以换成在for循环前 hashmap.push(0,-1);这样相当于把这种情况包含在了else if 里面
            if (key == k) max_length = i + 1;
                //不等于k的时候，找左边有没有相减=k的key
            else if (hashmap.containsKey(key - k))
                max_length = Math.max(max_length, i - hashmap.get(key - k));
            //假设之前已经有key存在了，就不需要再存一次了，因为用之前的计算可以计算出更远的区间
            if(!hashmap.containsKey(key))
                hashmap.put(key,i);
        }
        return max_length;
    }

    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualsK msss = new MaximumSizeSubarraySumEqualsK();
        System.out.println(msss.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
