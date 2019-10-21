import java.util.Stack;

/**
 * Created by 79300 on 2019/10/21.
 * 见pad笔记 LeetCode 84
 * stack里维持的永远是递增序列的index
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        for (int cur = 0; cur < heights.length; cur++) {
            if (stack.isEmpty() || heights[cur] >= heights[stack.peek()]) {
                stack.push(cur);
                //当前值比stack.peek的值小的话，说明可以找到stack.peek的左右边界了
            } else {
                int find_idx = stack.pop();
                int right_most = cur;
                int left_most = stack.isEmpty() ? -1 : stack.peek();
                max_area = Math.max(max_area, heights[find_idx] * (right_most - left_most - 1));
                //这个时候不改变cur的值还要继续比较，但for循环会++所以这里--
                cur--;
            }
        }
        //没有下一个元素之后栈内剩下的元素也是排好序的
        int right_most = stack.peek() + 1;
        while (!stack.isEmpty()) {
            int find_idx = stack.pop();
            //要是stack这个时候为空了，就说明可以一直延伸到最左边
            int left_most = stack.isEmpty() ? -1 : stack.peek();
            max_area = Math.max(max_area, heights[find_idx] * (right_most - left_most - 1));
        }
        return max_area;
    }
}
