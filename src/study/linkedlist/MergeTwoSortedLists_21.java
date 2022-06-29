package study.linkedlist;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list2.val < list1.val){
                ListNode temp = list1;
                list1 = list2;
                list2 = temp;
        }
        ListNode res = list1;
        while (list1!= null && list2!= null){
            ListNode temp = null;
            while (list1 != null && list1.val <= list2.val){
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            //swap
            ListNode swap = list1;
            list1 = list2;
            list2 = swap;
        }
        return res;
    }
}
