/**
 * Created by 79300 on 2019/10/2.
 * 一开始的思路是遍历一遍求到链表的size，然后把size-n+1的元素remove掉
 * one-pass：
 * 用到两个指针，一个fast和一个slow，维护中间的间距为n，当fast到链表尾部的时候，把slow.next结点remove掉
 * 需要用到dummy的原因是 我们始终改变的是slow.next 如果我们要删掉的是第一个结点，slow.next是无法定位到第一个结点的，除非slow=dummy
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast==null) return null;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
