package Linkedlist;

import java.util.HashMap;

/**
 * Created by yuehu on 5/30/19.
 */
public class MiddleOfLinkedList876 {
    public ListNode middleNode(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int listSize = 0;
        ListNode node = head;
        while(node != null) {
            map.put(listSize,node);
            listSize++;
            node = node.next;
        }
        return map.get(listSize / 2);
    }
}
