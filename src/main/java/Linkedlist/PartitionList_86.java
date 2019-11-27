package Linkedlist;

/**
 * Created by yuehu on 8/6/19.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;
        while(head != null) {
            ListNode temp = head;
            if(head.val < x){
                small.next = temp;
                small = small.next;
            }else{
                big.next = temp;
                big = big.next;
            }

            head = head.next;
        }

        small.next = bigHead.next;
        return smallHead.next;
    }
}
