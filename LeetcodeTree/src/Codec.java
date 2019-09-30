import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 79300 on 2019/9/28.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder result = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.append(node.val);
                result.append(",");
            }
            else{
                result.append("null,");
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        result.substring(0, result.length() - 1);
        return result.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String current = data.substring(1, data.length() - 1);
        String[] strings = current.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.offer(root);
        for (int i = 1; i < strings.length; i++) {
            TreeNode node = queue.poll();
            if (!strings[i].equals("null")) node.left = new TreeNode(Integer.parseInt(strings[i]));
            i++;
            if (i >= strings.length) break;
            if (!strings[i].equals("null")) node.right = new TreeNode(Integer.parseInt(strings[i]));
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }
}
