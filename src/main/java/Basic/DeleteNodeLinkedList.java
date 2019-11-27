package Basic;

/**
 * Created by yuehu on 10/24/17.
 */
public class DeleteNodeLinkedList {

    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        //loop each element till end of the list
        //last node points to null
        while (current != null) {
            System.out.print(current.val + "-->");
            //print current element's data
            //then move to next element

            current = current.next;
        }
        System.out.println(current);
    }
    public ListNode deleteNode(ListNode head, int value) {
//        ListNode current = head;
//        ListNode temp = null;
//        if (current != null && current.val == value) {
//            head = head.next;
//            return head;
//        }
//        while (current != null && current.val != value) {
//            temp = current;
//            current = current.next;
//
//            if (current == null) {
//                return head;
//            }
//            temp.next = current.next;
//        }
//        return head;
//    }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (current.val == value) {
                if (prev == null) {
                    return current.next;
                } else {
                    prev.next = current.next;
                    return head;
                }
            } else {
                prev = current;
                current = current.next;

                return head;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(2);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);

        //Attach them together to form a list
        head.next = second;
        second.next = third;
        third.next = fourth;
        DeleteNodeLinkedList s = new DeleteNodeLinkedList();
        s.display(head);
        ListNode result = s.deleteNode(head, 7);
        s.display(result);

    }
}
