package practice.leetcode.medium;

/**
 * traverse down
 * need to compare the current with pre
 * when larger than pre, return 1
 */
public class BinaryTreeLongestConsecutiveSequence {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, null, 1);
        return max;
    }

    private void helper(TreeNode root, Integer last, int len) {
        if (root == null) {
            return;
        }
        if (last != null && (last + 1 == root.val)) {
            len += 1;
            max = Math.max(max, len);
        } else if (last != null && last + 1 != root.val) {
            len = 1;
        }
        helper(root.left, root.val, len);
        helper(root.right, root.val, len);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n2.left = n1;
        n2.right = n3;
        n3.right = n4;
        BinaryTreeLongestConsecutiveSequence st = new BinaryTreeLongestConsecutiveSequence();
        System.out.println(st.longestConsecutive(n2));
    }
}
