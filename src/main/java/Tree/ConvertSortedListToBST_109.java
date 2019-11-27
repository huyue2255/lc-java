package Tree;



/**
 * Created by yuehu on 8/8/19.
 * 最后给出来的树的形状
 *          3
 *        2   5
 *      1   4
 */


public class ConvertSortedListToBST_109 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }


    public TreeNode toBST(ListNode head,ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
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

        ConvertSortedListToBST_109 src = new ConvertSortedListToBST_109();
//        System.out.println(src.sortedListToBST(a).val);
        TreeNode head = src.sortedListToBST(a);
        TreeNode left = head.left;
//        System.out.println(left.val);
//        System.out.println(left.left.val);
        TreeNode right = head.right;
        System.out.println(right.val);
        System.out.println(right.left.val);
    }
}
