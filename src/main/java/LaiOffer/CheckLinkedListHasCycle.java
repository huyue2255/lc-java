package LaiOffer;

/**
 * Created by yuehu on 11/11/19.
 */
public class CheckLinkedListHasCycle {
    public boolean checkLinkedListHasCircle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
