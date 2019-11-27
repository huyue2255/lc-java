package LaiOffer;

/**
 * Created by yuehu on 11/11/19.
 */
public class FindMidNodeOfLinkedList {
    public ListNode findMidNodeOfLinkedList(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(13);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        FindMidNodeOfLinkedList s = new FindMidNodeOfLinkedList();
        System.out.println(s.findMidNodeOfLinkedList(l1).val);

    }
}
