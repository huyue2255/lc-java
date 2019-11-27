package Linkedlist;

/**
 * Created by yuehu on 5/2/19.
 * 206.Reverse a singly linked list.

 Example:
 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 A linked list can be reversed either iteratively or recursively.

 走一遍：
 3 -> 4 -> 5
 h    t

 3 -> null  4 -> 5
 h     p    t

 3 -> null  4 -> 5
            t
 p          h

======================
 4 -> 3 -> null   5
                  t
 p                h
======================
 4 -> 3 -> null   5 -> null
                        t
 p                h


 5 -> 4 -> 3 -> null
                 t
 p               h

 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}
