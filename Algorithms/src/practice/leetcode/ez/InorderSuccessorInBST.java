package practice.leetcode.ez;
/**
 * @tree
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
        20
    10      45
  8   17
    16 18
         19

  8->10  10->16  19->20  20->45  45->null
  10->8  18->17  19->18  20->19  8->null
 */
/**
 * determine which side to go => determine which subtree it is in
 * compare root value and p value
 * if root > p go to left child
 *    root = p go to right child
 *    root < p go to right child
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }

    // follow up:
    // predecessor
    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val) {
            return predecessor(root.left, p);
        }
        TreeNode right = predecessor(root.right, p);
        return right == null ? root : right;
    }
}
