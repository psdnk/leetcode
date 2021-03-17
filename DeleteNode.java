public class DeleteNode {

    public class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        ListNode ptr = node;
        ListNode ptr1 = node;

        int v = node.val;
        while (ptr.next != null && temp != null){
            int val = ptr.val;
            ptr.val = temp.val;
            temp.val = val;
            ptr= ptr.next;
            temp = temp.next;
        }

        while(ptr1.next.val != v && ptr1 != null){
            ptr1 = ptr1.next;
        }
        ptr1.next = null;



    }
}
