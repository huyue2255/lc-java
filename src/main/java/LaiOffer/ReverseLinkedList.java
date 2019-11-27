package LaiOffer;



/**
 * Created by yuehu on 11/11/19.
 */


public class ReverseLinkedList {

    public ListNode reverseLinkedList(ListNode head) {
       if (head == null || head.next == null) return head;
       ListNode pre = null;
       ListNode cur = head;
       while (cur != null) {
           ListNode nextNode = cur.next;
           cur.next = pre;
           pre = cur;
           cur= nextNode;
       }
        return pre;

    }

    public ListNode reverseLinkedListI(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode newNode = reverseLinkedList(head.next);
      head.next.next = head;
      head.next = null;
      return newNode;

    }

    public static void main(String[] args) {
        ReverseLinkedList l = new ReverseLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;

        System.out.println(l.reverseLinkedListI(l1).val);



    }


}
