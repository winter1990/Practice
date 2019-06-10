package practice.leetcode.hard;

/**
 * @math
 *
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 *
 * Input: n = 13, k = 2
 * Output: 10, [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
 *
 * the whole sequence is like a tree structure
 * because of no leading zeroes, so only root has 9 numbers, all the other nodes have 10 children
 *                    root [1-9]
 *          1      2       3   ...    9
 *      /   | \   / | \   / |       / |  \
 *    10 11...19 20...29 30..      90 91...99
 * 100 101
 * n = 105, k = 12
 *
 * traverse down the tree and count the number of nodes in left subtree that is smaller than k, until k = 0
 * traverse level by level
 *   when going to the next level at i, we need to calculate how many nodes are between i and i+1
 *   so that all the nodes under i can be skipped
 *
 * steps to get the # of nodes between i and i+1
 *   i+1 is the right node of i, in the same level. if i=9 then next is 0
 *   if n2 <= n, we can skip all nodes under n1, add n2-n1
 *   if n2 > n, the largest node is between n1 and n2, add n-n1+1
 *
 *
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        --k;
        while (k > 0) {
            int count = getCount(n, cur, cur + 1);
            if (count <= k) {
                k -= count;
                cur++;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int getCount(int n, long a, long b) {
        int count = 0;
        while (a <= n) {
            if (b <= n) {
                count += b - a;
            } else {
                count += n - a + 1;
            }
            a *= 10;
            b *= 10;
        }
        return count;
    }
}
