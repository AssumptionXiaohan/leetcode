import java.util.HashMap;

/**
 * Created by 79300 on 2019/9/26.
 */
public class HouseRobberIII {
    HashMap<TreeNode,Integer> hashMap = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        //假设要include当前结点
        if(hashMap.containsKey(root)) return hashMap.get(root);
        int include_value = 0;
        if (root.left != null) {
            include_value += rob(root.left.right) + rob(root.left.left);
        }
        if (root.right != null) {
            include_value += rob(root.right.left) + rob(root.right.right);
        }
        //在不include当前结点和include当前结点的结果中取最大值
        hashMap.put(root,Math.max(rob(root.left) + rob(root.right), include_value+root.val));
        return hashMap.get(root);
    }
}
