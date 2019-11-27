package Linkedlist;

/**
 * Created by yuehu on 5/13/19.
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 */
public class RemoveLinkedListElements203 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy =new  ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while(p.next != null) {
            if(p.next.val == val) {
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return dummy.next;
    }

}


//    public static ListNode removeElements(ListNode head, int val) {
//        if(head == null) return head;
//        ListNode dummy =new  ListNode(0);
//        dummy.next = head;
//        ListNode p = dummy;
//
//        while(p.next != null) {
//            if(p.next.val == val) {
//                p.next = p.next.next;
//            }else {
//                p = p.next;
//            }
//        }
//        return dummy.next;
//    }