import java.util.List;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
            return null;
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast= head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        return null;
    }
}
