package practice.leetcode.medium;

/**
 * @tree
 *
 * preorder traversal -> root node first -> left subtree -> right subtree
 * which values belong to left -> sub array that smaller than root
 * which values belong to right -> sub array that larger than root
 * recursively build the tree
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[left]);
        int i = left + 1;
        while (i <= right && preorder[i] < preorder[left]) {
            i++;
        }
        node.left = buildTree(preorder, left + 1, i - 1);
        node.right = buildTree(preorder, i, right);
        return node;
    }

    /**
     * O(N) solution
     */
    int i = 0;
    public TreeNode bstFromPreorder1(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}
