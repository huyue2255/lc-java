package Linkedlist;

/**
 * Created by yuehu on 5/13/19.
 * 83. Remove duplicates from sorted list
 * Given a sorted linked list, delete all duplicates such tha each element appear only once
 */
public class RemoveDuplicatesfromSortedList83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
       ListNode cur = head;
       while(cur.next != null){
           if(cur.next.val == cur.val){
               cur.next = cur.next.next;
           }else {
               cur = cur.next;
           }
       }
       return head;
    }
}


//    public static ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode cur = head;
//        while(cur.next  != null) {
//            if(cur.next.val == cur.val) {
//                cur.next = cur.next.next;
//            }else {
//                cur = cur.next;
//            }
//        }
//        return head;
//    }