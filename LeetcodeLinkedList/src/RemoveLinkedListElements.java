/**
 * Created by 79300 on 2019/10/2.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null) {
            if (current.next.val == val) current.next = current.next.next;
            else current = current.next;
        }
        return dummy.next;
    }
}
