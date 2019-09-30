/**
 * Created by 79300 on 2019/9/29.
 * 三个指针 一个指向上一层的parent node，一个是下一层的最左边结点，一个是下一层现在遍历到的结点
 */
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) return null;
        Node parent = root;
        Node childhead = null;
        Node current_child = null;
        while (parent != null) {
            while (parent!=null){
                if (parent.left != null){
                    //说明刚开始新的一层
                    if(childhead==null){
                        childhead = parent.left;
                        current_child = parent.left;
                    }else {
                        //说明之前已经有过current_child
                        current_child.next = parent.left;
                        current_child = current_child.next;
                    }
                }
                if (parent.right != null) {
                    if(childhead==null){
                        childhead = parent.right;
                        current_child = parent.right;
                    }else {
                        //说明之前已经有过current_child
                        current_child.next = parent.right;
                        current_child = current_child.next;
                    }
                }
                parent = parent.next;
            }
            //开始新的一层
            parent = childhead;
            childhead = null;
            current_child = null;
        }
        return root;
    }
}
