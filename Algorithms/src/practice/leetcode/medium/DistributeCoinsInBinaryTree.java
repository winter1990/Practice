package practice.leetcode.medium;

/**
 * @tree
 * @dfs
 *
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from
 * parent to child, or from child to parent.)
 * Return the number of moves required to make every node have exactly one coin.
 *
 *      1
 *     /  \
 *    0    0
 *     \
 *     3    output: 4
 *
 * translate the problem to -> the weight of the tree is balanced, with each node value is 1
 * the total weight and total number of nodes should be the same
 * use dfs to search from root to leaf node
 * for above example, the weight of all leaf nodes should be 1
 * we start with left subtree and reach the leaf node which is 3, we should move 2 to parent no matter what, so 2 steps
 * then go to upper level -> 0
 * weight of null node is 0, and on right subtree it is 3, so we need to move one up to parent
 * on right subtree, it is 0
 * moving up and down is the same as the purpose is to keep the balance to the tree -> abs
 *
 *
 * same as 968 and 834
 */
public class DistributeCoinsInBinaryTree {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        res += Math.abs(l) + Math.abs(r);
        return node.val + l + r - 1;
    }
}
