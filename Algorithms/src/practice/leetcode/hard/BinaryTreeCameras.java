package practice.leetcode.hard;

/**
 * @tree
 * @greedy
 *
 * Given a binary tree, we install cameras on the nodes of the tree.
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 *
 *          o
 *        /   \
 *       o     o
 *    /    \    \
 *   o     o     o
 *    \         /
 *     o       o
 * output: 3
 *
 * think about the root, if it has left child and right child, there are three cases:
 *   camera at root
 *   camera at left child
 *   camera at right child
 *   so the time complexity would be large
 * think about leaf, there are two cases:
 *   leaf node
 *   parent node -> better for any case
 *
 * three status:
 *   leaf, then need to add camera to its parent
 *   parent, add camera at the node
 *   parent, the parent of parent which has camera
 * return 0 - need to be covered by parent
 * return 1 - has a camera on it
 * return 2 - covered by its child
 */
public class BinaryTreeCameras {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? 1 + res : res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}
