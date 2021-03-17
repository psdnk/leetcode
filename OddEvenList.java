import javax.swing.*;
import java.util.List;

public class OddEvenList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = null;

        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " ,");
            temp = temp.next;

        }
        temp = oddEvenList( head );
        System.out.println();
        while (temp != null){
            System.out.print(temp.val + " ,");
            temp = temp.next;

        }

    }

      public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode oddEvenList(ListNode head) {
          ListNode oddPtr;
          ListNode evenPtr;
          ListNode startOfOdd;
          ListNode startOfEven;
          ListNode temp;
          if ( head == null ){
              return null;
          }
        if ( head.next == null  ){
            return head;
        }
        if ( head.next.next == null ){
            return  head;
        }
        oddPtr = head;
        evenPtr = head.next;
        startOfOdd =oddPtr;
        startOfEven = evenPtr;

        while (( evenPtr != null ) && ( evenPtr.next != null )){
            oddPtr.next = oddPtr.next.next;
            evenPtr.next = evenPtr.next.next;
            oddPtr = oddPtr.next;
            evenPtr = evenPtr.next;

        }

        oddPtr.next = startOfEven;

        return startOfOdd;


//        ListNode temp1 = evenPtr;
//        while (temp1 != null){
//            if ( temp1.next != null && temp1.next.next != null){
//                temp1 = temp1.next;
//                temp1 = temp1.next;
//                evenPtr.next = temp1;
//                evenPtr = evenPtr.next;
//            }else {
//                break;
//            }
//        }
//        System.out.println();
//        while (startOfEven != null){
//            System.out.print(startOfEven.val + " ");
//            startOfEven = startOfEven.next;
//        }
//
//        temp = oddPtr;
//        while (temp != null){
//            if ( temp.next != null && temp.next.next != null){
//                temp = temp.next.next;
//                oddPtr.next = temp;
//                oddPtr = oddPtr.next;
//            }else {
//                break;
//            }
//        }
//        while (startOfOdd != null){
//            System.out.print(startOfOdd.val + " ");
//            startOfOdd = startOfOdd.next;
//        }
//
//
//
//        return startOfOdd;



//          if ( head.next != null ){
//              evenPtr = head.next;
//          }
//
//          if ( evenPtr == null ){
//              return head;
//          }
//        ListNode retOddPtr = oddPtr;
//
//        ListNode temp = oddPtr;
//          while (temp != null && temp.next != null && temp.next.next != null){
//                temp = temp.next.next;
//                oddPtr.next = temp;
//                oddPtr =  oddPtr.next;
//          }
//          temp = head.next;
//        evenPtr = head.next;
//        ListNode retEvenPtr = evenPtr;
//        while (temp != null && temp.next != null && temp.next.next != null){
//            temp = temp.next.next;
//            evenPtr.next = temp;
//            evenPtr =  evenPtr.next;
//        }
//        evenPtr.next = null;
//        oddPtr.next = retEvenPtr;
//
//        return retOddPtr;



    }

}
