package Linkedlist;

/**
 * Created by yuehu on 8/6/19.
 */
public class ReverseLinedListII_92 {
    public ListNode reverseBetween(ListNode head, int m,int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        for (int i = 0; i < n-m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReverseLinedListII_92 s = new ReverseLinedListII_92();
        System.out.println(s.reverseBetween(a,2,4));
        System.out.println(a.next.val);
        System.out.println(b.next.val);
        System.out.println(c.next.val);
        System.out.println(d.next.val);
//        System.out.println(e.next.val);
    }
}
