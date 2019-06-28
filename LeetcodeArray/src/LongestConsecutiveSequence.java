import java.util.*;

/**
 * Created by 79300 on 2019/6/28.
 * 首先的想法是先把hashmap构建起来，先把除以数组长度得到的结果相同的数据放在一个ArrayList里
 * 然后把在这个arraylist里的数据，用之前做过的“放在合适的数组位置上"的操作，计算最大的consecutive的长度
 * <p>
 * 但这样会miss掉很多，比如[4,5,6,7,8,9]，hashmap会变成[0:4,5,6]、[1:7,8,9]漏掉了这种连贯性
 * 所以想构建这样的一个hashmap让hashmap.get(4)与get5、6、7、8、9都相等，都等于6
 * <p>
 * 在这个过程中发现其实变7的时候找到6、8还是可以一起变的，但是找到5-9全变就很难了
 * 所以我们每次只修改连续的两头端点，毕竟下一次找到的时候也只会找到端点，中间有重复的话不需要算进连续值了
 */
public class LongestConsecutiveSequence {
    /*        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] / nums.length;
            if (hashmap.containsKey(key)) {
                hashmap.get(key).add(nums[i]);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(nums[i]);
                hashmap.put(key, lst);
            }
        }
        int max_length = 0;
        Iterator it = hashmap.entrySet().iterator();
        while (it.hasNext()) {
            int[] array = new int[nums.length];
            int consecutive=0;
            Map.Entry entry = (Map.Entry) it.next();
            ArrayList lst = (ArrayList) entry.getValue();
            for (Object item : lst) {
                int index = (Integer) item % nums.length;
                array[index] = (Integer) item;
            }
            for (int j = 0; j < array.length; j++) {
                if(array[j]+j==array.length){
                    consecutive++;
                }
            }
            max_length = Math.max(max_length,consecutive);
        }

        return max_length;*/

    /*        Map<Integer, Integer> hashmap = new HashMap<>();
        int longest_consecutive = 0;
        for (int number : nums) {
            if (!hashmap.containsKey(number)) {
                //初始化为0，默认不存在左右连续的数值
                int sequence_left = 0, sequence_right = 0;
                //如果有连续的已经存在就更新这两个值
                if (hashmap.containsKey(number - 1)) {
                    sequence_left = hashmap.get(number - 1);
                }
                if (hashmap.containsKey(number + 1)) {
                    sequence_right = hashmap.get(number + 1);
                }
                //找到端点值并更新
                hashmap.put(number - sequence_left, sequence_left + sequence_right + 1);
                hashmap.put(number + sequence_right, sequence_left + sequence_right + 1);
                //更新一下自己的值，万一自己是端点呢 也就是sequence_left或者sequence_right有一个是0或者都是0的话
                hashmap.put(number,sequence_left+sequence_right+1);
                //更新longest_consecutive最大值
                longest_consecutive = Math.max(longest_consecutive, sequence_left + sequence_right + 1);
            }
        }
        return longest_consecutive;*/
    public int longestConsecutive(int[] nums) {
        //还是用hashset方便。。。
        Set<Integer> hashset = new HashSet<>();
        int longest_cons = 0;
        for (int number : nums) {
            hashset.add(number);
        }
        for(int number:nums){
            int pre=number-1,next=number+1;
            while (hashset.contains(pre)){
                hashset.remove(pre);
                pre--;
            }
            while (hashset.contains(next)){
                hashset.remove(next);
                next++;
            }
            longest_cons = Math.max(longest_cons,next-pre-1);
        }
        return longest_cons;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
