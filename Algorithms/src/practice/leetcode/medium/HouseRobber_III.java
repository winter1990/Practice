package practice.leetcode.medium;

/**
 * @tree
 *
 * recursively traverse down the tree
 * start with root, two choices: rob, notRob
 * if rob current node, then can not rob the child
 * if not rob current, then we can rob or not rob the child
 */
public class HouseRobber_III {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] val = dfs(root);
        return Math.max(val[0], val[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] total = new int[2];
        total[0] = node.val + left[1] + right[1];
        total[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return total;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2; n1.right = n3;
        n2.right = n4; n3.right = n5;
        HouseRobber_III h = new HouseRobber_III();
        System.out.println(h.rob(n1));

    }
}
