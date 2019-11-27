package Linkedlist;

/**
 * Created by yuehu on 7/24/19.
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy ;
        ListNode fast = dummy;
        dummy.next = head;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
