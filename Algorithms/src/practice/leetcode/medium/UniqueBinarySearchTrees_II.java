package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * divide and conquer
 *
 * recursively build the tree
 * range [1,n]
 * select the root 1,2...n
 * 1,left null,right [2,n]
 *
 * when building the tree, need to keep track of ALL the roots
 * so each recursive call, need a new list to store the root, which is the left/right subtree in upper level
 */
public class UniqueBinarySearchTrees_II {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int s, int e) {
        List<TreeNode> list = new LinkedList<>();
        if (s > e) {
            list.add(null);
            return list;
        }
        for (int i = s; i <= e; i++) { // select root
            List<TreeNode> left = helper(s, i - 1);
            List<TreeNode> right = helper(i + 1, e);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
