package LaiOffer;

/**
 * Created by yuehu on 11/11/19.
 */
public class ReorderLinkedList {
    public ListNode reorderLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = middleNode(head);
//        System.out.println("mid"+mid.val);
        ListNode one = head;
        ListNode two = mid.next;
//        System.out.println("one"+one.val);
//        System.out.println("two"+two.val);
        mid.next = null;

        return merge(one,two);
    }

    private ListNode middleNode(ListNode head) {
//        System.out.println("middle");
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println("slow"+slow.val);
        return slow;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
//            System.out.println(one.val);
//            System.out.println(two.val);
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
//            System.out.println("jjjj");
        }

        if (one != null) {
            cur.next = one;
        } else if (two != null){
            cur.next = two;
        }

//        System.out.println("merge"+dummy.next.val);
//        System.out.println("merge"+dummy.next.next.val);
//        System.out.println("merge"+dummy.next.next.next.val);

        return dummy.next;
    }

    private void print(ListNode head) {
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(10);
        ListNode l4 = new ListNode(20);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        ReorderLinkedList test = new ReorderLinkedList();
//        System.out.println("ddddd");
//        System.out.println(test.reorderLinkedList(l1).val);
//        System.out.println(test.reorderLinkedList(l1).next.val);
//        test.print(l1);
//        test.print(l1);
//        test.print(l3);
//        test.merge(l1,l3);
        test.print(test.reorderLinkedList(l1));

    }
}
