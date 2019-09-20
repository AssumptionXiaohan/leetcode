import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 79300 on 2019/9/20.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lst = new ArrayList<>();
        if(root==null) return lst;
        TreeNode p = root;
        queue.offer(p);
        while (!queue.isEmpty()){
            //存储当前queue的size，也就是这一层的元素个数，方便把同一层的元素加在同一个list里
            int current_size = queue.size();
            List<Integer> current_lst = new ArrayList<>();
            while (current_size>0){
                p = queue.poll();
                current_lst.add(p.val);
                if(p.left!=null){
                    queue.offer(p.left);
                }
                if(p.right!=null){
                    queue.offer(p.right);
                }
                current_size--;
            }
            lst.add(current_lst);
        }
        return lst;
    }
}
