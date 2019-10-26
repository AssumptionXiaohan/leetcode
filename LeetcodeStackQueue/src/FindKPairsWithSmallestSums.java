import java.util.*;

/**
 * Created by 79300 on 2019/10/22.
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return result;
        Queue<Map.Entry<String,Integer>> p_queue = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                if(o1.getValue()!=o2.getValue()){
                    return o2.getValue()-o1.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - (o2[0] + o2[1]);
            }
        });
        //最多入堆k个,如果nums1比k小的话只需要nums1的所有元素与nums2[0]的pair入堆即可，也就是一共nums1.length个元素入堆
        //int[2] 表示现在的nums2取的index 用来判断有没有取到nums2的最后一位
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (result.size() < k && !queue.isEmpty()) {
            int[] current = queue.poll();
            result.add(Arrays.asList(current[0], current[1]));
            //到结尾了的话需要继续poll下一个值了，也就是下一个nums1的值
            if (current[2] == nums2.length - 1) {
                continue;
            }
            //没到结尾的话需要挪到下一个nums2的值
            queue.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
        }
        Map<Integer,Integer> hashMap = new HashMap<>();

        return result;
    }
}
