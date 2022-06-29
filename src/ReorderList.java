public class ReorderList {
    public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        ListNode currNode = head;
        int len = 0;
        while (currNode != null){
            currNode = currNode.next;
            len++;
        }
        int count = len/2;
        currNode = head;
        while (count>0){
            currNode = currNode.next;
            count--;
        }
        ListNode reverse = reverse(currNode);
        currNode = head;
        ListNode next = null;
        ListNode revnext = null;
        while (currNode != null){
             next = currNode.next;
             currNode.next = reverse;
             revnext = reverse.next;
             reverse=revnext;
             currNode = next;
        }

        currNode = head;
        while (currNode != null){
            System.out.print(currNode.val + "->");
            currNode = currNode.next;
        }

    }

    public  ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
