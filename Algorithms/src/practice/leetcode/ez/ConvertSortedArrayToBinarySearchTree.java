package practice.leetcode.ez;

/**
 * @array
 * @tree
 *
 * choose the root first:
 * element in the middle as the root so that tree is well-balanced though it is not the requirement
 * recursively get the root from left half of array and right half
 * need two index start and end to keep track of the index
 * if there are 2 elements, mid = 0, e = mid - 1 = -1, start = 0 -> based condition: start > end -> return null
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] arr, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = buildTree(arr, s, mid - 1);
        n.right = buildTree(arr, mid + 1, e);
        return n;
    }
}
