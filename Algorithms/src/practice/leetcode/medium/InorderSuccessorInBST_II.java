package practice.leetcode.medium;

/**
 * @tree
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 * You will have direct access to the node but not to the root of the tree.
 * Each node will have a reference to its parent node.
 *
 *         10
 *       /    \
 *      6     12
 *    /  \      \
 *   2   8      16
 *      /
 *     7
 * 2 -> left most in parent's right subtree
 * 7 -> parent
 * 8 -> root (node = parent.right)
 * 10 -> right child
 *
 */
public class InorderSuccessorInBST_II {
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        if (x.right == null) {
            Node cur = x.parent;
            while (cur != null && cur.val < x.val) {
                cur = cur.parent;
            }
            return cur;
        } else {
            Node cur = x.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
    }

    class Node {
        Node left, right, parent;
        int val;
        public Node() {
        }
    }
}
