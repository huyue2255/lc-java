package LaiOffer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuehu on 9/6/20.
 */
public class LowestCommonAncestorOfKNode {
    // Assumptions: the list of node is not null or empty
    // all the nodes in the list are guaranteed to be in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode l = helper(root.left, set);
        TreeNode r = helper(root.right, set);
        if (l != null && r != null) {
            return root;
        }
        return l != null ? l : r;
    }

}
