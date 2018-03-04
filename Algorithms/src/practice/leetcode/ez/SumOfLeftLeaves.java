package practice.leetcode.ez;

/**
 *     3
 *    / \
 *   9  20
 *     / \
 *   15   7
 *   result 24
 *
 * dfs
 * base: left child & leaf
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        } else {
            res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        SumOfLeftLeaves ap = new SumOfLeftLeaves();
        System.out.println(ap.sumOfLeftLeaves(n1));
    }
}
