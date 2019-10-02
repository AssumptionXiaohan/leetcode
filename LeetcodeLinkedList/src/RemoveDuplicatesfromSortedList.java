/**
 * Created by 79300 on 2019/10/2.
 * 要注意的是如果current.val==current.next.val,删掉current.next的时候不需要移动current指针
 * 移动的话变成current.next就是新的值了，这个值会被错过和上一个值比较
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
