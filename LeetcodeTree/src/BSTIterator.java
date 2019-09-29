import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by 79300 on 2019/9/28.
 */
public class BSTIterator {
    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        queue = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            queue.offer(current.val);
            current = current.right;
        }

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return queue.size() != 0;
    }
}
