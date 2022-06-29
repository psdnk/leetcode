public class ReverseNodesInKGroup_25 {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode next = null;
        for (int index=0;index<k&& end!= null;index++)end = end.next;
        ListNode prev = reverse(start,end);
        if (head != null){
            next = reverseKGroup(head.next,k);
            prev.next = next;
        }
        return prev;
    }

    public ListNode reverse(ListNode start,ListNode end){
        ListNode prev = null;
        while (start != end){
            ListNode next = start.next;
            start.next =prev;
            prev = start;
            start = next;
        }
        return prev;
    }
}
