package Tree;

/**
 * Created by yuehu on 8/8/19.
 *
 * given: [1,2,3,4,5]
 *      3
 *    1   4
 *      2   5
 *      以上才是正确的树的形状
 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums,int left, int right) {
        if(left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid-1);
        node.right = helper(nums,mid+1,right);
        return node;
    }

    public static void main(String[] args) {
       int[] s = {1,2,3,4,5};
        ConvertSortedArraytoBinarySearchTree_108 a = new ConvertSortedArraytoBinarySearchTree_108();
        System.out.println(a.sortedArrayToBST(s).val);
        TreeNode head = a.sortedArrayToBST(s);
        System.out.println(head.left.val);
        TreeNode left = head.left;
        System.out.println(left.right.val);

    }
}
