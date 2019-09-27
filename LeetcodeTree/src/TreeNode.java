import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 79300 on 2019/9/19.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode getTree(){
        return TreeNode.getRoot(TreeNode.getNodeList());
    }

    private static ArrayList<Integer> getNodeList(){
        Integer[] a = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        ArrayList<Integer> arrayList = new ArrayList();
        for (Integer t : a) {
            arrayList.add(t);
        }
        return arrayList;
    }

    private static TreeNode getRoot(List<Integer> input) {
        TreeNode root = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();

        for (int i = 0; i < input.size(); i++) {
            if (queue.isEmpty()) {
                queue.offer(root = new TreeNode(input.get(i)));
                continue;
            }

            TreeNode t = queue.poll();
            if (input.get(i) != null) t.left = new TreeNode(input.get(i));
            i++;
            if (input.get(i) != null) t.right = new TreeNode(input.get(i));
            if (t.left != null) queue.offer(t.left);
            if (t.right != null) queue.offer(t.right);
        }
        return root;
    }
}
