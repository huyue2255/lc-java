package Basic;

/**
 * Created by yuehu on 10/24/17.
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
