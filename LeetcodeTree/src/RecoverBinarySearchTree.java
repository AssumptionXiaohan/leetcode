/**
 * Created by 79300 on 2019/9/29.
 * Morris Tranversal
 * 我太难了 真的看不懂
 * https://blog.csdn.net/tyler_download/article/details/72599057
 * https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * 中序遍历出来找到的非递增的两个位置，交换这两个数字就可以
 * 难点在于如何用constant space中序遍历一个二叉树
 * 也就是morris tranversal 涉及到修改树的形状（改变指针位置）和恢复树的形状
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;
        //中序遍历的上一个结点previous
        TreeNode previous = null;
        TreeNode first = null, second = null;
        while (current != null) {
            //1-左节点为空
            if (current.left == null) {
                //System.out.println(current);
                if(previous!=null&&previous.val>=current.val){
                    if(first==null){
                        first = previous;
                        second = current;
                    }
                    else second = current;
                }
                previous = current;
                current = current.right;
            } else {
                //找到前序结点pre
                TreeNode pre = current.left;
                //这里注意一个条件pre.right!=current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                //2-左节点不为空 a-前序结点没有右孩子
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                    //2-左节点不为空 b-前序结点有右孩子
                } else if (pre.right != null && pre.right == current) {
                    //恢复树结构
                    pre.right = null;
                    //System.out.println(current);
                    if(previous!=null&&previous.val>=current.val){
                        if(first==null){
                            first = previous;
                            second = current;
                        }
                        else second = current;
                    }
                    previous = current;
                    current = current.right;
                }
            }
        }
        //交换这两个位置
        if (first != null && second != null) {
            int value = first.val;
            first.val = second.val;
            second.val = value;
        }
    }
}
