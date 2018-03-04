package practice.leetcode.ez;

/**
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = a + b;
            a = b;
            b = cur;
        }
        return cur;
    }
}
