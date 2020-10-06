package LaiOffer;

/**
 * Created by yuehu on 9/19/20.
 * Q: Path from leaf to root
 *
 *          -3 (left -> right)
 *        /   \
 *     -90     80 (right -> left)
 *      / \   / \
 *     4  5  11 -71
 *    / \  \
 *   2  10 13
 */
public class MaxPathSumLeafToRootInBST {
    // Method 1: Pass down the prefix sum
    public int findmaxPathSum (TreeNode root) {
        // Assumptions: root != null
        return maxPathSumI(root,0);
    }


   private int maxPathSumI (TreeNode root, int sum) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else if (root.left == null) {
            return maxPathSumI(root.right, sum);
        } else if (root.right == null) {
            return maxPathSumI(root.left, sum);
        }
        return Math.max(maxPathSumI(root.left, sum), maxPathSumI(root.right, sum));
   }

   // Method 2: Bottom up return the max suffix sum.
    public int findmaxPathSumII (TreeNode root) {
        // Assumptions: root != null
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            return findmaxPathSumII(root.right) + root.val;
        }
        if (root.right == null) {
            return findmaxPathSumII(root.left) + root.val;
        }
        return root.val + Math.max(findmaxPathSumII(root.left), findmaxPathSumII(root.right));
    }

    // Method 3:
    public int findmaxPathSumIII (TreeNode root) {
        int[] globalMax = new int[] {Integer.MIN_VALUE};
        maxPathSumIII(root,0,globalMax);
        System.out.println("final globalMax" + globalMax[0]);
        return globalMax[0];
    }

    private void maxPathSumIII(TreeNode root, int prefixSum, int[] globalMax) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            globalMax[0] = Math.max(prefixSum + root.val, globalMax[0]);
            System.out.println("globalMax"+globalMax[0]);
            return;
        }
        maxPathSumIII(root.left, prefixSum + root.val, globalMax);
        maxPathSumIII(root.right, prefixSum + root.val, globalMax);
    }

    // Method 4: DP solution: 从上往下 max sub-array sum. 同 Method 1
    // sum represents frm root node to current node.
    // the largest sum of the passed prefix (must include current node)
    // Time: O(n)
    // Space = O(n)
    public void helper (TreeNode root, int[] max, int sum) {
        //  base case
        if (root == null) {
            return;
        }
        if (sum < 0) {
            sum = root.val;
        } else {
            sum += root.val;
        }
        max[0] = Math.max(max[0], sum);
        helper(root.left, max, sum);
        helper(root.right, max, sum);
    }

    public int findMaxPathCostI(TreeNode root) {
        // Assumptions: root is not null
        // result stores the global maximum path sum and will be

        int[] result = new int[] {Integer.MIN_VALUE};
        helper(root, result, 0);
        return result[0];
    }

    // Method 5: DP solution: 从下往上 max sub-array sum. 同 Method 2
    public int helperI(TreeNode root, int[] max, int sum) {
        // base case
        if (root == null) {
            return 0;
        }
        int left_largesum = helperI(root.left, max,sum);
        int right_largesum = helperI(root.right, max,sum); // step 1

        int tmp = Math.max(0,Math.max(left_largesum, right_largesum));
        max[0] = Math.max(max[0],tmp + root.val);

        return tmp + root.val;
    }

    public int findMaxPathCostII(TreeNode root) {
        // Assumptions: root is not null
        // result stores the global maximum path sum and will be

        int[] result = new int[] {Integer.MIN_VALUE};
        helperI(root, result, 0);
        return result[0];
    }


    public static void main(String[] args) {
        MaxPathSumLeafToRootInBST m = new MaxPathSumLeafToRootInBST();
        TreeNode root = new TreeNode(-3);
        TreeNode t1 = new TreeNode(-90);
        TreeNode t2 = new TreeNode(80);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(-71);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(12);
        TreeNode t10 = new TreeNode(13);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
//        t4.left = t9;
        t4.right = t10;
        System.out.println(m.findMaxPathCostI(root));
    }
}
