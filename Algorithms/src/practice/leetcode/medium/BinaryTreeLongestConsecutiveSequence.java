package practice.leetcode.medium;

/**
 * @tree
 * @recursion
 *
 * along the parent-child connections
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * traverse down, and the sequence must be increasing (3-4-5 valid, 3-2 not valid)
 * need to compare the current with pre
 *
 * recursively traverse the tree
 * each call - parent node, current node and current length
 * base case: node == null
 * cur.val==p.val+1 len+=1, update max value
 * cur.val!=p.val+1 len=1
 */
public class BinaryTreeLongestConsecutiveSequence {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverseTree(root, null, 1);
        return max;
    }

    private void traverseTree(TreeNode node, TreeNode last, int currentLen) {
        if (node == null) {
            return;
        }
        if (last != null && (node.val == last.val + 1)) {
            currentLen += 1;
            max = Math.max(max, currentLen);
        } else if (last != null && (node.val != last.val + 1)) {
            currentLen = 1;
        }
        traverseTree(node.left, node, currentLen);
        traverseTree(node.right, node, currentLen);
    }
}
