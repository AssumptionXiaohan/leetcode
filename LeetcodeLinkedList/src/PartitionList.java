/**
 * Created by 79300 on 2019/10/7.
 * 建两个dummynode 一个连小于x的结点 一个连大于等于x的结点
 * 记得把他们和原链表断掉
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode Dummyless = new ListNode(0);
        ListNode Dummygreater = new ListNode(0);
        ListNode less = Dummyless;
        ListNode greater = Dummygreater;
        while (head!=null){
            if(head.val<x){
                less.next = head;
                less = less.next;
            }else {
                greater.next = head;
                greater = greater.next;
            }
            ListNode node = head.next;
            head.next = null;
            head = node;
        }
        less.next = Dummygreater.next;
        return Dummyless.next;
    }
}
