package practice.leetcode.ez;

/**
 * @array
 * @recursion
 *
 * choose the root first:
 * element in the middle as the root so that tree is well-balanced though it is not the requirement
 * recursively get the root from left half of array and right half
 * need two index start and end to keep track of the index
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = helper(arr, s, mid - 1);
        n.right = helper(arr, mid + 1, e);
        return n;
    }
}
