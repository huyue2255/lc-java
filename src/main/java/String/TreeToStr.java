package String;

/**
 * Created by yuehu on 11/20/18.
 * 606
 */

public class TreeToStr {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public String treeToStr1(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        help(sb, t);
        return sb.toString();
    }

    public void help(StringBuffer sb, TreeNode t) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append("(");
                help(sb, t.left);
                sb.append(")");
                if (t.right != null) {
                    sb.append("(");
                    help(sb, t.right);
                    sb.append(")");
                }
            }
        }
    }
    public static  void main(String[] args) {
        TreeNode t  =  new TreeNode(4);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
//        TreeNode r1 = new TreeNode(1);
        t.left = l;
        t.right = r;
        l.left = l1;
//        l.right = r1;

        TreeToStr res = new TreeToStr();
        res.treeToStr1(t);
        System.out.println(res.treeToStr1(t));


    }
}
