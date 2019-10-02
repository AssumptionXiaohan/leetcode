/**
 * Created by 79300 on 2019/10/1.
 * 把mNode结点一直往nNode结点后插，操作n-m次
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mNode = head;
        ListNode nNode = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = mNode;
            mNode = mNode.next;
        }
        for (int i = 0; i < n - 1; i++) {
            nNode = nNode.next;
        }

        while (mNode != nNode) {
            pre.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            //更新mNode
            mNode = pre.next;
        }
        //不能直接return head，因为m=1的话会改变head指针的位置
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII rl = new ReverseLinkedListII();
        ListNode head=new ListNode(3);
        ListNode second = new ListNode(5);
        head.next = second;
        System.out.println(rl.reverseBetween(head,1,2).val);
        System.out.println();
    }
}
