/**
 * Created by 79300 on 2019/10/2.
 * https://www.youtube.com/watch?v=1I82s08OE0c
 * 需要newHead.next=null切断和后面的联系，否则dummy.next会返回整条链表
 * 包括一开始dummy和head也是不连的，pre的移动可以通过current来赋值
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode newHead = dummy;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            if ((pre == dummy || pre.val != current.val) && (current.next == null || current.next.val != current.val)) {
                newHead.next = current;
                newHead = current;
            }
            pre = current;
            current = current.next;
            newHead.next = null;
        }
        return dummy.next;
    }
}
