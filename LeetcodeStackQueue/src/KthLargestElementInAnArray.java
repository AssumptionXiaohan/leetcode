import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/21.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int num:nums){
            pq.offer(num);
            while (pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
