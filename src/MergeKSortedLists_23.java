import java.util.PriorityQueue;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(Integer.MAX_VALUE);
        ListNode ret = new ListNode(0);
        ListNode curr = ret;
        while (!pq.isEmpty()) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    pq.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            if (!pq.isEmpty() && pq.peek()!= Integer.MAX_VALUE){
                curr.next = new ListNode(pq.poll());
                curr = curr.next;
            }
        }
        return ret.next;
    }
}
