package Linkedlist;

/**
 * Created by yuehu on 8/1/19.
 * 61. Rotate List
 * For example:
 * Given: 1->2->3->4->5->null  and k = 2;
 * return: 4->5->1->2->3->null
 *
 * time:O(n)
 * space:O(1);
 */
public class RotatedList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode index = head;
        int len = 1;
        while(index.next != null) {
            index = index.next;
            len++;
        }

        index.next = head;

        for(int i = 1; i < len - k % len; i++){
            head = head.next;
        }

        ListNode res = head.next;
        head.next = null;
        return res;
    }
}
