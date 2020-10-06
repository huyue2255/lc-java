package LaiOffer;

/**
 * Created by yuehu on 9/20/20.
 */
public class ReconstructBSTPostorder {
    public TreeNode reconstruct (int[] post) {
        // Assumptions: post is not null
        // there is no duplicate in the binary search tree
        // Traversing position of the post order,
        // We traverse and construct the binary search tree
        // from the postOrder right to left.
        int[] index = new int[] {post.length - 1};
//        return helper(post, index, Integer.MIN_VALUE);
        return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper (int[] postorder, int[] index, int min) {
        // Since it is a binary search tree,
        // the "min" is actually the root
        // and we are using the root value to determine the boundary
        // of left/right subtree
//        if (index[0] < 0 || postorder[index[0]] <= min) {
        System.out.println("postorder[index[0]]" + postorder[index[0]]);
        System.out.println("min" + min);
            if (index[0] < 0 || postorder[index[0]] <= min) {
                return null;
            }
        System.out.println("index[0]--:" + index[0]);
//        System.out.println("index:" + index);
        TreeNode root = new TreeNode(postorder[index[0]--]);
//        System.out.println("index--: after" + index);
//        System.out.println("index[0]--: after " + index[0]);
        root.right = helper(postorder, index, root.val);
        root.left = helper(postorder, index, min);
        return root;
    }

    public static void main(String[] args) {
        int[] post = {12,20,15,10};
        ReconstructBSTPostorder r = new ReconstructBSTPostorder();
        TreeNode res = r.reconstruct(post);
//        System.out.println(res.val);
//        System.out.println(res.left.val);
//        System.out.println(res.right.val);
//
//        TreeNode t1 = res.left;
//        TreeNode t2 = res.right;
//
//        System.out.println(t1.left.val);
//        System.out.println(t1.right.val);
//
//        System.out.println(t2.left.val);

        System.out.println(res.val);
        TreeNode t2 = res.right;

        System.out.println(t2.val);

        TreeNode t3 = t2.right;
        System.out.println(t3.val);

        TreeNode t4 = t2.left;
        System.out.println(t4.val);

    }
}
