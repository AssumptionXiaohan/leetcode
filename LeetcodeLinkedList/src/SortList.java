import java.util.List;

/**
 * Created by 79300 on 2019/10/4.
 * 不用递归用遍历写一个merge函数,merge函数里还要处理尾部的信息
 * <p>
 * bottom to up mergeSort, 主函数第一个for循环把
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //先求list的长度
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //MergeSort for循环的次数是logN
        for (int step = 1; step < length; step = step * 2) {
            //prev作为当前step下的头结点位置
            ListNode prev = dummy;
            //current_node表示在当前step下，链表分割到的位置，一直到分割完为止
            ListNode current_node = dummy.next;
            while (current_node != null) {
                //一次分割出两个部分来然后merge
                ListNode left = current_node;
                ListNode right = split(left, step);
                current_node = split(right, step);
                //这一次merge的尾部就是下两个部分merge接上的部分
                prev = mergeTwoLists(left, right, prev);
            }
        }
        return dummy.next;
    }

    //分离前n个元素，返回n+1开始的头
    private ListNode split(ListNode head, int n) {
        if (head == null) return null;
        for (int i = 0; head.next != null && i < n - 1; i++) {
            head = head.next;
        }
        ListNode nextHead = head.next;
        head.next = null;
        return nextHead;
    }

    //合并两个sorted list，并把新合并的list加到head后面
    //返回现在两个sorted list的尾部，成为下一次调用的新head
    private ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode head) {
        ListNode current = head;
        if (l1 == null){
            current.next=l2;
        }
        if (l2 == null){
            current.next=l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            if (l1 == null) current.next = l2;
            if (l2 == null) current.next = l1;
        }
        while (current.next != null) current = current.next;
        return current;
    }
}
