package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @tree
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * Return a list of all possible full binary trees with N nodes.
 * Each element of the answer is the root node of one possible tree.
 * Each node of each tree in the answer must have node.val = 0.
 * You may return the final list of trees in any order.
 *
 * 1 ok, 2 no, 3 ok, 4 no, 5 ok...
 * only odd number of nodes can form a full tree, because root is 1 node, other nodes must be even number
 *
 * we can choose the root first, get left subtrees and right subtree set
 */
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N -= 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> l = allPossibleFBT(i);
            List<TreeNode> r = allPossibleFBT(N - i);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
