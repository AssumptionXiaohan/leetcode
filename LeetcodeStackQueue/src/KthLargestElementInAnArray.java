import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/21.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //实现最小堆 每次把更小的po出去，堆里留下的永远是最大的三个
        Queue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            while (pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
