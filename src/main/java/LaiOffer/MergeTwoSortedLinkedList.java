package LaiOffer;

/**
 * Created by yuehu on 11/16/19.
 */
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1.next != null && l2.next != null) {
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1.next != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public void print(ListNode head) {
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;


        ListNode s1 = new ListNode(23);
        ListNode s2 = new ListNode(53);
        ListNode s3 = new ListNode(182);
        s1.next = s2;
        s2.next = s3;

        MergeTwoSortedLinkedList a = new MergeTwoSortedLinkedList();
        a.print(a.mergeTwoSortedLinkedList(l1,s1));
    }


}
