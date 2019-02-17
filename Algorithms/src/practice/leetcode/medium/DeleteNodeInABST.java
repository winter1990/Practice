package practice.leetcode.medium;

/**
 * @tree
 *
 * recursively traverse the tree, set left and right sub tree
 * bst -> compare with key value
 * while key=root value
 * leaf - null
 * has left - return left
 * has right - return right
 * has both
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode newRoot = root.right, par = null;
                while(newRoot.left != null){
                    par = newRoot;
                    newRoot = newRoot.left;
                }
                if (par == null) {
                    newRoot.left = root.left;
                    return newRoot;
                }
                par.left = newRoot.right;
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode newRoot = root.right;
                TreeNode cur = newRoot;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return newRoot;
            }
        }
        return root;
    }
}
