public class FlattenAMultilevelDoublyLinkedList {
    public DLLNode flatten(DLLNode head) {
        DLLNode curr = head;
        while (curr != null){
            DLLNode nextNode = curr.next;
            if (curr.child != null){
                curr.next = flatten(curr.child);
                curr.child = null;
                while (curr.next != null){
                    curr.next.prev = curr;
                    curr = curr.next;
                }
            }
            curr.next = nextNode;
            if (nextNode != null){
                nextNode.prev = curr;
            }
            curr = nextNode;
        }
        return head;
    }

    public DLLNode helper(DLLNode head){
        DLLNode curr = head;
        while (curr != null && curr.child != null){
        if (curr != null && curr.child!= null) {
            DLLNode next = curr.next;
            curr.next = flatten(curr.child);
            curr.child = null;
            while (curr.next != null) {
                curr.next.prev = curr;
                curr = curr.next;
            }
            if (next != null) {
                next.prev = curr;
            }
            curr = next;
        }
        }
        return head;
    }


}
