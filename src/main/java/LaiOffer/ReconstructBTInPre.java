package LaiOffer;

import com.sun.org.apache.bcel.internal.generic.INEG;
import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 9/20/20.
 */
public class ReconstructBTInPre {
    // Method 1: Utilizing the inOrder sequence to determine
    // the size of left/right subtrees.
    public TreeNode reconstruct (int[] in, int[] pre) {
        // Assumptions: pre, in are not null, there is no duplicates
        // in the binary tree, the length of pre and in are guaranteed
        // to be the same

        Map<Integer, Integer> inIndex = indexMap(in);
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }

    private Map<Integer, Integer> indexMap(int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return map;
    }

    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        // get the position of the root in inOrder sequence, so that we will know
        // the size of left/right subtree
        int inMid = inIndex.get(root.val);
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
        return root;
    }


    // Method 2:
//    public TreeNode reconstructI (int[] preorder, int[] inorder) {
//        // Assumptions: pre, in are not null, there is o duplicates
//        // in the binary tree, the length of pre and in are guaranteed
//        // to be the same
//
//        Map<Integer, Integer> map = indexMap(inorder);
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return helper(preorder, inorder, 0, preorder.length - 1,0, inorder.length - 1,  map);
//    }
//
//    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
//        if (inorder == null || preorder == null || inorder.length != preorder.length) {
//            return null;
//        }
//        if (preStart > preorder.length - 1 || inStart > inEnd) {
//            return null;
//        }
//
//        int rootIndex = map.get(preorder[preStart]);
//        TreeNode root = new TreeNode(preorder[preStart]);
//
//        root.left = helper(preorder, inorder, preStart + 1, preStart + rootIndex - inStart, inStart, rootIndex - 1, map);
//        root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd, map);
//        return root;
//    }

    //method 3: 少一个参数

    public TreeNode reconstructI (int[] preorder, int[] inorder) {
        // Assumptions: pre, in are not null, there is o duplicates
        // in the binary tree, the length of pre and in are guaranteed
        // to be the same

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0,0, inorder.length - 1,  map);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        int rootIndex = map.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);

        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);
        root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, map);
        return root;
    }
}
