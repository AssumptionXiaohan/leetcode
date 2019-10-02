/**
 * Created by 79300 on 2019/10/1.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode next_pair = swapPairs(head.next.next);
        ListNode temp = head.next;
        head.next = next_pair;
        temp.next = head;
        return temp;
    }
}
