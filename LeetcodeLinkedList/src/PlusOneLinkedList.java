/**
 * Created by 79300 on 2019/10/2.
 * 找到最右边的一个非9数字+1，剩下的0个或多个9全部变成0即可。
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy;
        //current=dummy可以自动handle最高位是9的进位情况
        ListNode current = dummy;
        while (current != null) {
            if (current.val != 9) lastNotNine = current;
            current = current.next;
        }
        //因为这个时候current已经是null了，要把current移到lastNotNine后面第一个9的位置
        current = lastNotNine.next;
        lastNotNine.val++;
        while (current != null) {
            current.val = 0;
            current = current.next;
        }

        return dummy.val != 0 ? dummy : dummy.next;
    }
}
