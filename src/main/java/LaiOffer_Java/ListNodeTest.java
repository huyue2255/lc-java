package LaiOffer_Java;

import java.util.List;

/**
 * Created by yuehu on 8/19/19.
 */
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

}
public class ListNodeTest {
    private int length(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private ListNode get(ListNode head, int index) {
        while (index > 0 && head != null) {
            head = head.next;
            index--;
        }
        return head;
    }

    private ListNode appendHead(ListNode head, int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        return newHead;
    }

    private ListNode appendTail(ListNode head, int value) {
        //1. head == null
        if(head == null) {
            return new ListNode(value);
        }
        //2.head != null, find the last node in the list
        ListNode pre = head;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = new ListNode(value);
        return head;
    }

    private ListNode deleteNode(ListNode head, int target) {
        if (head == null) {
            return null;
        }else if(head.value == target) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.value != target) {
            cur = cur.next;
        }

        if (cur.next != null){
            cur.next = cur.next.next;
        }
        return head;
    }
//not sure yet which node will be head when constructing the list
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (h1 != null && h2 != null) {
            if(h1.value < h2.value){
                cur.next = h1;
                h1 = h1.next;
            }else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }

        if(h1 != null) {
            cur.next = h1;
        }

        if(h2 != null){
            cur.next = h2;
        }
        return dummy.next;
    }

    //the head could be changed when solving the problem
    private ListNode insert(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newNode = new ListNode(val);
        ListNode cur = dummy.next, pre = dummy;
        while(cur != null && cur.value < val) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = newNode;
        newNode.next = cur;
        return dummy.next;
    }





    public static void main(String[] args) {
//        ListNode head = new ListNode(3);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(5);
//        ListNodeTest t = new ListNodeTest();
//        System.out.println(t.length(head));
//
//        ListNode result = t.get(head,2);
//        System.out.println(result.value);
//
//        t.appendTail(head,12);
//        ListNode result1 = t.get(head,3);
//        System.out.println(result1.value);
//
//        t.deleteNode(head,4);
//        System.out.println(head.next.value);

        int i = 0, j = 0;
        System.out.println(i++);
        System.out.println(++j);
    }
}
