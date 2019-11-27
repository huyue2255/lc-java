package Linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/6/19.
 */
public class RemoveDuplicatesfromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int samNum = p.next.val;
                while(p.next != null && p.next.val == samNum) {
                    p.next = p.next.next;
                }
            }else{
                p= p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        ListNode dummy = new ListNode(0);
        dummy.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        List<Integer> list = new ArrayList<>();
        while(a != null){
              list.add(a.val);
              a = a.next;
        }
        System.out.println(list);
//
//        System.out.println(list);
//        RemoveDuplicatesfromSortedListII_82 s = new RemoveDuplicatesfromSortedListII_82();
//        s.deleteDuplicates(a);
//        System.out.println(a.val);
//        List<Integer> list = new ArrayList<>();

//


    }
}
