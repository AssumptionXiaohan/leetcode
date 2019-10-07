import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 79300 on 2019/10/7.
 * 需要用到优先级队列 把所有的头结点都add进去再弹出一个最小的
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pqueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int size = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < size; i++) {
            if (lists[i] != null)
                pqueue.add(lists[i]);
        }
        while (!pqueue.isEmpty()) {
            ListNode node = pqueue.poll();
            current.next = node;
            current = current.next;
            if (current.next != null) pqueue.add(current.next);
        }
        return dummy.next;
    }
}
