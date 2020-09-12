package LaiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 9/9/20.
 */
public class DeepCopyLinkedListRandom {
    // Method 1: using HashMap to avoid copy mutiple times for the same node
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head,new RandomListNode(head.val));
            }
            cur.next = map.get(head);

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.val));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
