package practice.leetcode.medium;

import java.util.PriorityQueue;

/**
 * @tree
 *
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root
 * any shorter prefix of a string is lexicographically smaller
 *
 * normally we start and compare from the root
 * use a priority queue to handle the sorting of the strings
 * use a string builder to append the character when traversing down the tree
 * if reaching the leaf, then we add the string to the pq
 * the first string in pq will be the smallest
 */
public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
        helper(root, sb, pq);
        return pq.poll();
    }

    private void helper(TreeNode node, StringBuilder sb, PriorityQueue<String> pq) {
        if (node == null) {
            return;
        }
        sb.insert(0, (char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            pq.offer(sb.toString());
        }
        helper(node.left, sb, pq);
        helper(node.right, sb, pq);
        sb.deleteCharAt(0);
    }

    /**
     * method 2
     * divide and conquer
     * recursively traverse down the tree
     * when we get the left and right string, compare and return the smaller one
     *      d
     *     / \
     *    c  b
     *     \
     *      a
     */
    public String smallestFromLeaf1(TreeNode root) {
        return helper(root);
    }

    private String helper(TreeNode node) {
        if (node == null) {
            return "";
        }
        char c = (char)('a' + node.val);
        String l = helper(node.left);
        String r = helper(node.right);
        if (l.length() > 0 && r.length() > 0) {
            return l.compareTo(r) < 0 ? l + c : r + c;
        } else if (l.length() > 0) {
            return l + c;
        } else {
            return r + c;
        }
    }

    /*
     * think carefully why this solution is wrong with the tree [0 null 1]
     * if we traverse down the tree and add the char to left first, if left is not leaf
     * then we are adding to the wrong path
    private String helper(TreeNode node) {
        if (node == null) {
            return "";
        }
        char c = (char)('a' + node.val);
        if (node.left == null && node.right == null) {
            return "" + c;
        }
        String l = helper(node.left) + c;
        String r = helper(node.right) + c;
        return l.compareTo(r) < 0 ? l : r;
    }
    */

}
