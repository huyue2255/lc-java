package Linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * Created by yuehu on 9/18/19.
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
       if(head == null || head.next == null) return;
       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode temp = null;
       ListNode l1 = head;
       ListNode slow = head, fast = head;
       while (fast != null && fast.next != null) {
           temp = slow;
           slow = slow.next;
           fast = fast.next.next;
       }
       temp.next = null;
       ListNode l2 = reverse(slow);
       merge(l1,l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        while (l1 != l2) {
            l1.next = l2;
            if(n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
