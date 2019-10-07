/**
 * Created by 79300 on 2019/10/3.
 * recursive
 */
public class MergeTwoSortedLists {
    /*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if(l1.val>l2.val){
                l2.next = mergeTwoLists(l2.next,l1);
                return l2;
            }else {
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }
        }*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            if (l1 == null) current.next = l2;
            if (l2 == null) current.next = l1;
        }
        return dummy.next;
    }
}
