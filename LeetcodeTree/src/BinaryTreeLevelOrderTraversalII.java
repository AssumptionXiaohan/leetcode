import java.util.LinkedList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/26.
 * 层次遍历的变化题型，要从bottom-up往上加list
 * 用一个linkedlist，addfirst好像没啥毛病
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        depth_record(root,result,0);
        return result;
    }
    //返回结点的depth
    public void depth_record(TreeNode node, LinkedList<List<Integer>> result,int depth){
        if(node==null) return;
        if(depth==result.size()){
            result.addFirst(new LinkedList<>());
            result.get(0).add(node.val);
        }else {
            //这里的result.size()-depth-1是为了计算当前depth的结点应该被加在哪个list里
            result.get(result.size()-depth-1).add(node.val);
        }
        depth_record(node.left,result,depth+1);
        depth_record(node.right,result,depth+1);
    }
}
