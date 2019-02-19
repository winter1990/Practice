package practice.leetcode.medium;

/**
 * @tree
 * @dp
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * start with thinking properties of BST, all left nodes smaller and all right nodes larger
 * [0] -> 1
 * [1] -> 1
 * [1 2] -> 2 [1 null 2] or [2 1]
 * [1 2 3] -> 1 * 2 + 1 * 1 + 2 * 1 we choose root node first which can be 1/2/3 (any node can be chosen as root)
 * [1 2 3 4] the result is based on the values calculated previously
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {  // number of i nodes
            for (int j = 1; j <= i; j++) {  // choose the root
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
        System.out.println(ub.numTrees(3));
    }
}
