package Basic;

/**
 * Created by yuehu on 11/9/17.
 */
public class ReverseLinkedlist {


    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);

        ListNode cur = head;


        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }

        return dummy.next;
        }


    public void display(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode current = head;
        //loop each element till end of the list
        //last node points to null
        while (current != null) {
            System.out.print(current.data + "  ");
            //print current element's data
            //then move to next element
            current = current.next;
        }
        System.out.print(current);
    }


    public static void main(String args[]) {

        ReverseLinkedlist s = new ReverseLinkedlist();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);
        head.next = second;
        second.next = third;
        third.next = fourth;

        ListNode r = s.reverseList(head);
        s.display(r);
    }
}


