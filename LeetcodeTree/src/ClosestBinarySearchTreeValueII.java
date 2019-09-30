import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/29.
 * 用deque存储中序遍历的内容
 * 然后从两端remove直到size==k
 */
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(root, deque);
        while (deque.size() > k) {
            if (Math.abs(deque.getLast() - target) > Math.abs(deque.getFirst() - target)) {
                deque.removeLast();
            } else {
                deque.removeFirst();
            }
        }
        return (List) deque;
    }

    private void inorder(TreeNode root, Deque<Integer> deque) {
        if (root == null) return;
        inorder(root.left, deque);
        deque.add(root.val);
        inorder(root.right, deque);
    }

}
