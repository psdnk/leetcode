public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        if (curr == null || curr.next == null) return curr;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
}
