package LaiOffer;

import java.util.HashMap;

/**
 * Created by yuehu on 9/24/20.
 */
public class ReconstructBTInPost {
    // Method 1: Utilizing the inOrder sequence to determine
    // the size of left/right subtrees.
    public TreeNode reconstruct(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder,
                            int inStart, int inEnd, int postStart,
                            int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart < 0) {
            return null;
        }

        int rootIndex = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);

        root.left = helper(inorder, postorder, inStart,rootIndex -1, postStart,postStart + rootIndex - inStart - 1, map);

        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1, map);
        return root;
    }
}
