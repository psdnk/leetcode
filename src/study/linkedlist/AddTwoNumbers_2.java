package study.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode temp = start;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry !=0){
             sum = (l1 != null ? l1.val : 0)  + (l2 != null ? l2.val : 0) + carry;
             carry = sum/10;
             ListNode node = new ListNode(sum%10);
             temp.next = node;
             temp = temp.next;
             l1 = l1!=null ? l1.next : l1;
             l2 = l2!=null ? l2.next : l2;
        }
        return start.next;
    }
}
