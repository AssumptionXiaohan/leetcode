/**
 * Created by 79300 on 2019/10/3.
 * 因为数字在链表里是reverse order，头结点就是个位数，直接加即可
 * 用一个carry表示进位1
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode h1 = l1, h2 = l2;
        int carry = 0;
        while (h1 != null || h2 != null) {
            //计算当前结点的和，考虑null的情况
            int current_value = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            if (current_value >= 10) {
                carry = 1;
                current_value = current_value - 10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(current_value);
            head.next = newNode;
            head = head.next;
            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        if (carry != 0) head.next = new ListNode(carry);
        return dummy.next;
    }
}
