package practice.leetcode.ez;

/**
 * start with root
 * if root.v=target 0 smallest
 * if larger, go to right
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
}
