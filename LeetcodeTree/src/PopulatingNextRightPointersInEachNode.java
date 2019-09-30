import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 79300 on 2019/9/29.
 * 应该还算是层次遍历的变形
 * 层次遍历的时候记录上一个node pre指向current node，每一层遍历完的时候把最后一个current指向null
 * <p>
 * <p>
 * 不能用层次遍历qaq 要求constant space
 * 可以用前序遍历的递归形式--因为前序遍历能够先把root的左子结点和右子结点的next指针构建起来，才可以接着递归
 */
public class PopulatingNextRightPointersInEachNode {
/*  iteration
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        Node pre = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                if (pre != null) pre.next = node;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                pre = node;
                size--;
            }
            pre.next = null;
            pre = null;
        }
        return root;
    }*/

    public Node connect(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        //需要处理root没有next节点的情况
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
