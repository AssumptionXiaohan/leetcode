import java.util.*;

/**
 * Created by 79300 on 2019/9/30.
 * BFS的变形，需要用另外一个queue来记录每一个结点对应的column的值
 * 然后把column一致的结点放到一个list里添加进result
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        //用一个hashmap存储column和对应的list
        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        //BFS用到的两个队列
        Queue<Integer> col_queue = new LinkedList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        col_queue.offer(0);
        //用两个值记录col的最大最小值，因为需要按照col从小到大的顺序把对应的list添加到result里
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //BFS
        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            int col = col_queue.poll();
            //修改max和min的值
            max = Math.max(max, col);
            min = Math.min(min, col);
            //把当前结点加入对应的hashmap
            if (!hashmap.containsKey(col)) {
                hashmap.put(col, new ArrayList<>());
            }
            hashmap.get(col).add(node.val);
            //BFS
            if (node.left != null) {
                treeNodeQueue.offer(node.left);
                col_queue.offer(col - 1);
            }
            if (node.right != null) {
                treeNodeQueue.offer(node.right);
                col_queue.offer(col + 1);
            }
        }
        //遍历hashmap添加到result结果集
        for(int i=min;i<=max;i++){
            result.add(hashmap.get(i));
        }
        return result;
    }
}
