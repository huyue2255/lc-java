package LaiOffer_Java;

import java.util.List;

/**
 * Created by yuehu on 8/21/19.
 * offer()       poll()
 *     4<-3<-2<-1
 */
public class ImpQueueWithLinkedList {
    class ListNode {
        int value;
        ListNode next;
        ListNode pre;
        public ListNode(int value) {
            this.value = value;
        }
    }
    //offerLast pollFirst
    public class Queue {
        ListNode head;
        ListNode tail;

        public Queue() {
            head = tail = null;
        }

        public Integer poll() {
            if (head == null) {
                return null;
            }
            ListNode node = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }

            node.next = null;
            return node.value;
        }


        public Integer peek() {
            if (head == null) {
                return null;
            }
            return head.value;
        }

        public void offer(Integer ele) {
            if (head == null) {
                head = new ListNode(ele);
                tail = head;
            } else {
                tail.next = new ListNode(ele);
                tail = tail.next;

            }
        }

    }
}
