package practice.leetcode.medium;

/**
 * @tree
 * @dp
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * we want to build different tree with given values [1,N]
 * N = 1, 1
 * N = 2, [1 2] [2 1]
 *
 * so, what is the process when we build up a binary search tree with given sorted array?
 *   pick a root node
 *   all the values smaller than root will be in left sub tree
 *   all the values larger than root will be in the right subtree
 *   recursively pick the sub-root and go down (left and right)
 *
 * number of unique trees
 *   pick root [1, N]
 *   # of left * # of right = total # of combinations
 *
 * define dp[n+1]
 * dp[i] represents number of different trees with i nodes, i = [1,n]
 * initial states
 *   dp[0] -> 1
 *   dp[1] -> 1
 *
 * transition
 * i = [2 n], number of nodes in the tree
 *   j = [1 i], choose the root
 *     all combinations of:
 *       left subtree dp[j-1]
 *       right subtree dp[i-j]
 *     dp[i] += dp[j-1]*d[i-j]
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
