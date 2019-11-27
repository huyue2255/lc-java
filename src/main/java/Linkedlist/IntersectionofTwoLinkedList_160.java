package Linkedlist;

/**
 * Created by yuehu on 6/8/19.
 * 160. Intersection of Two Linked Lists
 * A:  a1->a2->a3
 *            c1->c2->c3
 * B:  b1->b2
 *
 *
 *
 * B: b1->b2->c1->c2->c3->a1->a2->a3->c1->c2->c3
 * A: a1->a2->a3->c1->c2->c3->b1->b2->c1->c2->c3
 */
public class IntersectionofTwoLinkedList_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
            int lenA = len(headA);
            int lenB = len(headB);

            if (lenA > lenB) {
                while (lenA != lenB) {
                    headA = headA.next;
                    lenA--;
                }
            } else {
                while (lenA != lenB) {
                    headB = headB.next;
                    lenB--;
                }
            }

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

        public int len(ListNode head) {
        int len = 1;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
