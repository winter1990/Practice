package practice.leetcode.medium;

/**
 * @tree
 *
 * Given the root node of a BST, return the sum of values of all nodes with value between L and R (inclusive)
 *          10
 *       5      15
 *     3  7        18
 * L = 7, R = 15, output = 32
 *
 * traverse down the tree recursively
 * if node value is smaller than left boundary, return
 * if node value is larger than right boundary, return
 */
public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        traverseTree(root, L, R);
        return sum;
    }

    private void traverseTree(TreeNode node, int l, int r) {
        if (node == null) {
            return;
        }
        if (node.val >= l && node.val <= r) {
            sum += node.val;
        }
        traverseTree(node.left, l, r);
        traverseTree(node.right, l, r);
    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val > L) {
            sum += rangeSumBST1(root.left, L, R);
        }
        if (root.val < R) {
            sum += rangeSumBST1(root.right, L, R);
        }
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        return sum;
    }
}
