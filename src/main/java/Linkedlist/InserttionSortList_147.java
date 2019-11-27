package Linkedlist;

/**
 * Created by yuehu on 9/21/19.
 */
public class InserttionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, pre = null;
        while(cur != null && cur.next !=null ) {
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }else {
                temp = cur.next;
                cur.next = temp.next;
                pre = dummy;
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }

                temp.next = pre.next;
                pre.next = temp;
            }
        }

        return dummy.next;
    }

}
