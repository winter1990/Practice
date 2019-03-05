package practice.leetcode.ez;

/**
 * @tree
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * start with root
 * if root.value = target, then 0 is the smallest
 * if target is larger than root value, go to right sub-tree
 * if target is smaller than root value, go to left sub-tree
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if (root.val == target) {
            return root.val;
        }
        int v1 = root.val;
        TreeNode next = target > v1 ? root.right : root.left;
        if (next == null) {
            return v1;
        }
        int v2 = closestValue(next, target);
        return Math.abs(v1 - target) > Math.abs(v2 - target) ? v2 : v1;
    }

    public int closestValue1(TreeNode root, double target) {
        int res = root.val;
        TreeNode node = root;
        while (node != null) {
            if (Math.abs(node.val - target) < Math.abs(res - target)) {
                res = node.val;
            }
            if (node.val > target) {
                node = node.left;
            }
            if (node.val < target) {
                node = node.right;
            }
        }
        return res;
    }
}
