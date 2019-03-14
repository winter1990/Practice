package practice.leetcode.medium;

/**
 * @tree
 *
 * Input: root = [4,1,3,null,null,2], val = 5, Output: [5,4,null,1,3,null,null,2]
 * Explanation: A = [1,4,2,3], B = [1,4,2,3,5]
 *
 * Input: root = [5,2,4,null,1], val = 3, Output: [5,2,4,null,1,null,3]
 * Explanation: A = [2,1,5,4], B = [2,1,5,4,3]
 *
 * Input: root = [5,2,3,null,1], val = 4, Output: [5,2,4,null,1,3]
 * Explanation: A = [2,1,5,3], B = [2,1,5,3,4]
 *
 * for first example, 5 is larger than root and as it is a maximum tree, so 5 is the new root node
 * for second example, find the root node, 5 and 4, 3 are in the right subtree, then 4 is the root for subtree
 * and 3 is on the right side, 3 will be the leaf node
 * for third example: root is 5, after appending 4 at last, 4 will be new root for the right subtree
 *
 * start with root node, because the value is appended at the last of the array
 * so it's either the root node, or in the right subtree
 *
 */
public class MaximumBinaryTree_II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
