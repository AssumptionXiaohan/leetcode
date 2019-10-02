/**
 * Created by 79300 on 2019/10/2.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
