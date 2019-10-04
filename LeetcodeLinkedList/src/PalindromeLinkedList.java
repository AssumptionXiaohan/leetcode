/**
 * Created by 79300 on 2019/10/3.
 * 翻转后半部分的链表再逐个比较
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail;
        //fast==null说明是偶数，直接reverse slow，fast!=null说明是奇数，reverse slow.next
        if(fast==null){
            tail = reverse(slow);
        }else {
            tail = reverse(slow.next);
        }

        while (tail!=null){
            if(tail.val!=head.val) return false;
            tail = tail.next;
            head = head.next;
        }

        return true;
    }


    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
