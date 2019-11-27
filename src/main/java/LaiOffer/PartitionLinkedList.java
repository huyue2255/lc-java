package LaiOffer;

/**
 * Created by yuehu on 11/11/19.
 * be careful of head and tail node
 * DummyNode
 * Why or when should we use a dummy node?
 * when we want to append new elements to an initially empty linkedlist,
 * we do not have an initial head node. In this case, we can new a dummy node to act a head node
 */
public class PartitionLinkedList {
    public ListNode partitionLinkedList(ListNode head, int target) {
        if (head == null || head.next == null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;

        while (head != null) {
            if (head.val < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }

        curSmall.next = large.next;
        curLarge.next = null;

        return small.next;
    }
    private void print(ListNode head) {
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;


        ListNode s1 = new ListNode(23);
        ListNode s2 = new ListNode(53);
        ListNode s3 = new ListNode(182);
        s1.next = s2;
        s2.next = s3;

        PartitionLinkedList a = new PartitionLinkedList();
        a.print(a.partitionLinkedList(l1,7));

    }
}
