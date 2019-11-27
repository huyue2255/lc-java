package Tree;

/**
 * Created by yuehu on 8/9/19.
 */
public class PopulatingNextRightPointersinEachNode_116 {
        public class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {}

        public TreeLinkNode(int _val,TreeLinkNode _left,TreeLinkNode _right,TreeLinkNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left != null){
            root.left.next = root.right;
        }

        if(root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }

    public void connect2(TreeLinkNode root) {
       TreeLinkNode start = root;
       while(start != null) {
           TreeLinkNode cur = start;
           while(cur != null){
               if(cur.left != null){
                   cur.left.next= cur.right;
               }

               if(cur.right != null && cur.next != null){
                   cur.right.next = cur.next.left;
               }
               cur = cur.next;
           }
           start = start.left;
       }
    }
}
