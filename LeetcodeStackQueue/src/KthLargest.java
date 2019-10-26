import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/25.
 */
public class KthLargest {
    Queue<Integer> priority_queue;
    int size;

    public KthLargest(int k, int[] nums) {
        priority_queue= new PriorityQueue<>();
        size = k;
        for(int i=0;i<nums.length;i++){
            priority_queue.offer(nums[i]);
        }
        while(priority_queue.size()>k){
            priority_queue.poll();
        }
    }

    public int add(int val) {
        priority_queue.offer(val);
        while(priority_queue.size()>size){
            priority_queue.poll();
        }
        return priority_queue.peek();
    }
}
