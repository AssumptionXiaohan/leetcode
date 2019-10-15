import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 79300 on 2019/10/14.
 * there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number).
 * Most usually, when the array is sorted in one direction, we can use index as "search space"
 * when the array is unsorted and we are going to find a specific number, we can use "range".
 *
 * 还是用堆吧 range BS太难了..
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        for (int i = 0; i < matrix.length && i < k; i++) {
            heap.add(new int[]{i, 0});
        }

        int count = 0;
        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            count++;
            if (count == k) return matrix[current[0]][current[1]];
            if (current[1] + 1 < matrix[0].length) heap.add(new int[]{current[0], current[1] + 1});
        }
        return -1;
    }
}
