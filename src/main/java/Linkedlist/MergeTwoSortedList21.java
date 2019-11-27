package Linkedlist;

/**
 * Created by yuehu on 5/13/19.
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Time: O(n) space: O(1)
 */
public class MergeTwoSortedList21 {
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while(l1 != null && l2 != null){
          if(l1.val <= l2.val){
              cur.next = new ListNode(l1.val);
              l1 = l1.next;
          }else if(l1.val > l2.val){
              cur.next = new ListNode(l2.val);
              l2 = l2.next;
          }
          cur = cur.next;
      }

        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }
}
