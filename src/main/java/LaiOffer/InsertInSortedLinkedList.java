package LaiOffer;

/**
 * Created by yuehu on 11/11/19.
 */
public class InsertInSortedLinkedList {
    public ListNode insertNodeToLinkedList(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        ListNode pre = head;
        if (pre == null || pre.val >= value) {
            newNode.next = head;
            return newNode;
        }

        while (pre.next != null && pre.next.val < value) {
            pre = pre.next;
        }

        newNode.next = pre.next;
        pre.next = newNode;
        return head;
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
        InsertInSortedLinkedList s = new InsertInSortedLinkedList();
        s.insertNodeToLinkedList(l1,10);
        s.print(s.insertNodeToLinkedList(l1,10));

    }
}
