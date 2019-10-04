/**
 * Created by 79300 on 2019/10/3.
 * 先reverse后半部分的链表
 * 然后把后半部分的链表插入前半部分
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //这样fast=head.next可以让slow停止在前一个链表的末尾
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //只要reverse slow.next就可以
        ListNode tail = reverse(slow.next);
        //为了让begin往后读取的时候不要读过了
        slow.next = null;

        //Merge head和tail两个链表
        ListNode begin = head;

        while (tail != null) {
            ListNode temp_begin = begin.next;
            ListNode temp_tail = tail.next;
            begin.next = tail;
            tail.next = temp_begin;
            begin = temp_begin;
            tail = temp_tail;
        }


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

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReorderList rl = new ReorderList();
        rl.reorderList(a);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
