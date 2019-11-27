package Basic;

/**
 * Created by yuehu on 9/26/18.
 */
public class MergeTwoSortList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
                System.out.println("l1");
            } else {
                prev.next = l2;
                l2 = l2.next;
                System.out.println("l2");
            }
            prev = prev.next;
            System.out.println("inside loop1");
        }
        prev.next = l1 == null ? l2 : l1;
        System.out.println("inside loop2");
        System.out.println("data"+prehead.next.data);

        return prehead.next;
    }

    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
    }

    public static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String args[]) {
        System.out.println("hhhell  merge");
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(11);

        ListNode l1 = new ListNode(12);
        ListNode l2 = new ListNode(13);
        ListNode l3 = new ListNode(17);
        ListNode l4 = new ListNode(23);

        //Attach them together to form a list

        head.next = second;
        second.next = third;
        third.next = fourth;

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        MergeTwoSortList s = new MergeTwoSortList();
        s.display(s.mergeTwoLists(head, l1));

        if(l4.next == null) {
            System.out.println("null");
        }

    }

}
