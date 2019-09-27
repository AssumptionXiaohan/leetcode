import java.util.LinkedList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/26.
 * 超级高频的一道题！！！
 * 需要用一个linkedlist，能够头尾同时操作，用一个boolean标记现在是从右往左还是从左往右
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        //相当于层次遍历里的queue的作用 不过是可以双向操作的queue
        LinkedList<TreeNode> lst = new LinkedList<>();
        lst.add(root);
        //一个flag表示现在这层是从左往右还是从右往左遍历
        boolean left_to_right = true;
        while (!lst.isEmpty()) {
            int size = lst.size();
            List<Integer> cur_list = new LinkedList<>();
            while (size > 0) {
                TreeNode node;
                if (left_to_right) {
                    //如果该层是从左往右遍历，从lst的头开始取值
                    node = lst.pollFirst();
                    //从左往右加在list的尾部
                    if (node.left != null) lst.addLast(node.left);
                    if (node.right != null) lst.addLast(node.right);
                } else {
                    //如果是从右往左遍历，从lst的尾部开始取值
                    node = lst.pollLast();
                    //从右往左加在list的头部
                    if (node.right != null) lst.addFirst(node.right);
                    if (node.left != null) lst.addFirst(node.left);
                }
                cur_list.add(node.val);
                size--;
            }
            result.add(cur_list);
            //改变下一层的遍历的顺序
            left_to_right = !left_to_right;
        }
        return result;
    }
}
