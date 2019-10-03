/**
 * Created by 79300 on 2019/10/3.
 * 神奇的思路：两个指针，都需要走两条路径只是先后顺序问题。a+c+b=b+c+a
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode point_a = headA;
        ListNode point_b = headB;
        while (point_a != point_b) {
            point_a = point_a == null ? headB : point_a.next;
            point_b = point_b == null ? headA : point_b.next;
        }
        return point_a;
    }
}
