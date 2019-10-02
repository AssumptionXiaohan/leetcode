/**
 * Created by 79300 on 2019/10/1.
 * 把mNode结点一直往nNode结点后插，操作n-m次
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        ListNode begin=null,end=null,second_head=null;
        for (int i = 1; i < m-1; i++) {
            tail = tail.next;
        }
        begin = tail.next;
        for (int i = m; i < n; i++) {
            end = begin.next;
        }
        second_head = end.next;


    }
}
