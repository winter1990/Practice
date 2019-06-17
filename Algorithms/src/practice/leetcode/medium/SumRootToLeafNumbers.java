package practice.leetcode.medium;

/**
 * @tree
 *
 * base case:
 * reach the leaf node (left & right child null) add to sum
 * when traverse down the tree, previous level * 10 + current node value
 * need to keep track of each path in each recursive call
 * sum up all paths - global param
 */
public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int path) {
        if (root.left == null && root.right == null) {
            path = path * 10 + root.val;
            sum += path;
            return;
        }
        if (root.left != null) {
            helper(root.left, path * 10 + root.val);
        }
        if (root.right != null) {
            helper(root.right, path * 10 + root.val);
        }
    }

    /**
     * divide and conquer
     */
    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, 0);
    }

    private int sum(TreeNode root, int path) {
        if (root.left == null && root.right == null) {
            return path * 10 + root.val;
        }
        int sum = 0;
        if (root.left != null) {
            sum += sum(root.left, path * 10 + root.val);
        }
        if (root.right != null) {
            sum += sum(root.right, path * 10 + root.val);
        }
        return sum;
    }
}
