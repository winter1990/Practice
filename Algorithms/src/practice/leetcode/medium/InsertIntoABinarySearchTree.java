package practice.leetcode.medium;

/**
 * @tree
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into
 * the BST. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * there might be multiple ways to insert the node
 *          20
 *        /    \
 *     10       40
 *   /    \    /   \
 *  5     15  30    50
 * compare with current node value
 * there must be a leaf node that the val can fit into
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insertNode(root, val);
        return root;
    }

    private TreeNode insertNode(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val < val) {
            node.right = insertIntoBST(node.right, val);
        } else if (node.val > val) {
            node.left = insertIntoBST(node.left, val);
        }
        return node;
    }

    /**
     * iterative solution
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }
        return root;
    }
}
