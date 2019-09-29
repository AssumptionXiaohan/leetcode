import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/28.
 * 把LinkedLisk转换成arraylist然后用ConvertSortedArrayToBinarySearchTree的方法解
 */
public class ConvertSortedListToBinarySearchTree {
    List<Integer> array = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        array.add(head.val);
        while (head.next != null) {
            head = head.next;
            array.add(head.val);
        }
        return helper(array, 0, array.size() - 1);
    }

    public TreeNode helper(List<Integer> array, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(array.get(mid));
        node.left = helper(array, low, mid - 1);
        node.right = helper(array, mid + 1, high);
        return node;
    }
}
