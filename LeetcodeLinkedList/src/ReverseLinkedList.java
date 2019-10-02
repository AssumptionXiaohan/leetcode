import java.util.List;

/**
 * Created by 79300 on 2019/10/1.
 * 生成一个newHead,把结点的next指向newhead，然后把当前结点设置为新的newhead
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
