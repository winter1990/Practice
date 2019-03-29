package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
/**
 * @tree
 *
 * each nodes has different value
 * voyage is in preorder
 * all the left/right subtree should be in one group
 */
public class FlipBinaryTreeToMatchPreorderTraversal {
    public List<Integer> flipMatchVoyage(practice.leetcode.medium.TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        if (!dfs(root, voyage, new int[]{0}, res)) {
            res = new ArrayList<>();
            res.add(-1);
        }
        return res;
    }

    private boolean dfs(TreeNode node, int[] v, int[] i, List<Integer> res) {
        if (node == null) return true;
        if (node.val != v[i[0]++]) return false;
        if (node.left != null && node.left.val != v[i[0]]) {
            res.add(node.val);
            return dfs(node.right, v, i, res) && dfs(node.left, v, i, res);
        }
        return dfs(node.left, v, i, res) && dfs(node.right, v, i, res);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        int[] in = {1,3,2};
        FlipBinaryTreeToMatchPreorderTraversal f = new FlipBinaryTreeToMatchPreorderTraversal();
        System.out.println(f.flipMatchVoyage(n1, in));
    }
}
