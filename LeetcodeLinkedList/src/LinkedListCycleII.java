/**
 * Created by 79300 on 2019/10/3.
 * 快慢指针相遇即有环
 * 一个指针从相遇点开始，一个指针从起点开始走，最后相遇的地方就是环的起点
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        //用dummy可以处理循环点在head的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        //走到fast和slow相遇，slow==dummy是为了保证进入while循环 也可以去掉这个条件用do while
        while (fast != slow || slow == dummy) {
            //假设fast可以走到null说明链表是有结尾的，没有环
            if(fast==null||fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        //避免多用一个指针，直接让fast从头开始
        fast = dummy;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

/*
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
        LinkedListCycleII lc = new LinkedListCycleII();
        System.out.println(lc.detectCycle(a).val);

    }*/
}
