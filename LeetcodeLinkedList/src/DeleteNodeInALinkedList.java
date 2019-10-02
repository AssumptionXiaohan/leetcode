/**
 * Created by 79300 on 2019/10/2.
 * 因为访问不到node之前的结点，所以只能用之后的值覆盖这个值
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        while (node.next.next!=null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
        //还有一个更骚的办法
/*      这样子的话别的语言需要回收node.next jvm nb
        node.val = node.next.val;
        node.next = node.next.next;*/
    }

}
