package practice.leetcode.medium;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * 1-1,2-2,3-5
 *
 * 1-use 1 as root
 * 2-1 as root, right subtree has 1 node, use 2 as root, 1 node in left
 * 3-1 as root, 2 in right subtree, 2 as root, 1 left 1 right, 3 root, 2 left
 *
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int v = 0;
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    v += dp[i - 1];
                } else {
                    v += dp[j - 1] * dp[i - j];
                }
            }
            dp[i] = v;
        }
        return dp[n];
    }

    public int numTrees1(int n) {
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
