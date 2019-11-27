package LaiOffer_Java;

/**
 * Created by yuehu on 8/21/19.
 */
public class ImplStackWithLinkedList {
    class ListNode {
        int value;
        ListNode next;
        public ListNode (int value) {
            this.value = value;
        }
    }

    public class Stack {
        private ListNode head;
        public Stack() {
            head = null;
        }

        public Integer pop() {
            if (head == null) {
                return null;
            }

            ListNode pre = head;
            head = head.next;
            pre.next = null;
            return pre.value;
        }

        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.value;
        }

        public void push(Integer ele) {
            ListNode newNode = new ListNode(ele);
            newNode.next = head;
            head = newNode;
        }
    }




}
