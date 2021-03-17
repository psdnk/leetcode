public class FlattenDLL {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        Node temp = head;
        if ( head == null ) {
            return null;
        }
        while (( temp != null )) {

            if ( temp.child != null ) {

                Node tempNextPtr = temp;
                if ( temp.next != null ) tempNextPtr = temp.next;
                Node ptrStart = temp.child;
                //temp.child.prev= ptrStart;
                Node ptrEnd = ptrStart;
                while (ptrEnd.next != null) {
                    ptrEnd = ptrEnd.next;
                }
                temp.child = null;
                if ( temp.next != null )
                    temp.next = ptrStart;
                if ( ptrStart != null && ptrStart.prev != null )
                    ptrStart.prev = temp;
                if ( ptrStart != ptrEnd && ptrEnd.next != null )
                    ptrEnd.next = tempNextPtr;
                if ( tempNextPtr != null && tempNextPtr.prev != null )
                    tempNextPtr.prev = ptrEnd;
            }
            temp = temp.next;
        }
        Node tmp = head;
        while (tmp != null) {
            System.out.print ( tmp.val + " -> " );
            tmp = tmp.next;
        }
        return head;
    }
}
