/**
 * Created by 79300 on 2019/10/6.
 * 这题好像做的复杂了一点
 * 可以遍历一遍求到length之后知道要翻转多少次
 *
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //prev用来标志已经被翻转的尾部，接上下一次翻转好的linkedlist
        ListNode prev = dummy;
        while (head != null) {
            ListNode current_head = head;
            //移动k-1次
            for (int i = 0; i < k - 1; i++) {
                if (head.next != null) head = head.next;
                //走不到k-1次的话说明不需要再翻转了,把剩下的接到prev上直接return
                else{
                    prev.next = current_head;
                    return dummy.next;
                }
            }
            //分离head和后面的结点，把head挪到下一个位置
            ListNode temp = head.next;
            head.next = null;
            head = temp;
            //把前面被分出来的这段reverse，接到之前的尾部上
            prev.next = reverseList(current_head);
            //prev移到新的尾部
            while (prev.next != null) prev = prev.next;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
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
