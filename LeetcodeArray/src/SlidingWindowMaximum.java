import java.util.*;

/**
 * Created by 79300 on 2019/6/30.
 * monotonic queue 单调队列 单调递增或者单调递减
 * 一般采用deque来实现，方便（deque是两边都可出入的队列）
 * 这里用的是一个单调递减的 monotonic 队列 也就是从大到小的队列
 * 把比当前元素小的队尾元素删掉，因为不会再用到了，然后把当前元素push进去
 * 如果没有比当前元素小的队尾元素，直接push进去
 *
 * 这道题不能用最大堆的原因是因为，虽然最大堆能返回最大值，但是队尾无法删除元素只能进出
 * 所以我们需要一个两端都可以做删除操作的有序队列
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        if (k == 1) return nums;
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new PriorityQueue<>();

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //当deque为空的时候直接加进去
            if (deque.isEmpty()) {
                deque.offerLast(i);
                //队尾元素比当前元素小的删掉，再把当前元素push进去
            } else if (nums[deque.peekLast()] <= nums[i]) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                //队尾元素比当前元素大，把当前元素加在后面
            } else {
                deque.offerLast(i);
            }
            //符合条件的时候加入结果集(前k-1个不用加到结果集里
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
            //窗口每次挪一个，如果最大值的index是被挪走的那一个的index就要删除，因为取不到了
            if (deque.peekFirst() == i - k + 1) {
                deque.pollFirst();
            }

        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(swm.maxSlidingWindow(new int[]{7,2,4}, 2)));
    }
}
