package LaiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuehu on 9/12/20.
 */
public class MergeKSortedList {
    public ListNode merge(List<ListNode> listOfLists) {
        // Assumptions: listOfLists is not null, non of the lists is null.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(11, new MyComparator());
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode node: listOfLists) {
            if (node != null) {
                minHeap.offer(node);
                System.out.println("kkkkk"+node.val);
            }
        }
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            if (cur.next.next != null) {
                System.out.println("inside next loop");
                minHeap.offer(cur.next.next);
                System.out.println("next"+cur.next.next.val);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    static class MyComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val == o2.val) {
                return 0;
            }
            return o1.val < o2.val ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        ListNode z = new ListNode(3);
        x.next = y;
        y.next = z;

        ArrayList<ListNode> singleList = new ArrayList<ListNode>();
        singleList.add(a);
        singleList.add(x);

        MergeKSortedList m = new MergeKSortedList();
        System.out.println(m.merge(singleList));
    }
}
