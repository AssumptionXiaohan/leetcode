import java.util.*;

/**
 * Created by 79300 on 2019/10/21.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        //把数字和出现的次数对应起来
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        //用一个size为k的最小堆，保证每次堆里是frequency最大的数字
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        //遍历hashMap构建最终的最小堆
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            queue.offer(entry);
            if(queue.size()>k){
                queue.poll();
            }
        }
        //添加到结果集
        while (result.size()<k){
            result.add(queue.poll().getKey());
        }
        return result;
    }

}
