package LaiOffer;

/**
 * Created by yuehu on 7/3/20.
 *
 * Node1 -> Node2 -> Node3 -> Node4 -> null
 * Node2 <- Node1 -> Node4 -> Node 3 -> null
 */
public class ReverseListInPairs {
    // Method 1: recursion.
    // 1. start the recursion with head node of the original linked list
    // 2. every recursion call is responsible for swapping a pair of nodes.
    // let's represent the two nodes to be swapped by firstNode and secondNode.
    // 3. Next recursion is by calling the function with head of the next pair of node.
    // This cal would swap the next two nodes and make further recursive calls if there are nodes
    // left in the linked list.
    // 4.Once we get the pointer to the remaining swapped list from the recursion call, we call swap the firstNode
    // and secondNode.

    public ListNode reverseInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //Nodes to swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // swapping
        firstNode.next = reverseInPairs(head.next);
        secondNode.next = firstNode;

        return secondNode;

    }


    // Method 2: iterative.
    public ListNode reverseInPairsI(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur.next.next.next;
            next.next = cur.next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
