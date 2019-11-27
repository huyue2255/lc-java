package Linkedlist;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuehu on 5/13/19.
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.

 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;
        while(p1 != null || p1 != null) {
            if(p1 != null){
                sum = sum + p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum = sum + p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum %10);
            sum = sum / 10;
            cur = cur.next;
        }

        if(sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void print(ListNode s){
        while(s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode x = new ListNode(5);
        ListNode y = new ListNode(6);
        ListNode z = new ListNode(4);
        x.next = y;
        y.next = z;

        AddTwoNumbers2 res = new AddTwoNumbers2();
        ListNode result = res.addTwoNumbers(a,x);
        print(result);

    }

}
//
//    ListNode dummy = new ListNode(0);
//    ListNode cur = dummy;
//    int sum = 0;
//    ListNode p1 = l1, p2 = l2;
//        while (p1 != null || p2 != null) {
//                if (p1 != null) {
//                sum += p1.val;
//                p1 = p1.next;
//                }
//                if (p2 != null) {
//                sum += p2.val;
//                p2 = p2.next;
//                }
//
//                cur.next = new ListNode(sum % 10);
//                sum /= 10;
//                cur = cur.next;
//                }
//
//                if (sum == 1) {
//                cur.next = new ListNode(1);
//                }
//
//                return dummy.next;
