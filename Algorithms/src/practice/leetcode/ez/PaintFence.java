package practice.leetcode.ez;

/**
 * no more than two adjacent fence posts have the same color
 * n posts, k colors
 * basically two scenarios:
 * 1. color(n)!=color(n-1) last*(k-1)
 * 2. color(n)=color(n-1) so color(n)!=color(n-2) last last*(k-1)
 *
 * check MAX_VALUE before multiplication
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        if (k == 1 && n >= 3) {
            return 0;
        }
        int v1 = k;
        int v2 = k * k;
        if (n == 1) return v1;
        if (n == 2) return v2;
        int v3;
        for (int i = 3; i <= n; i++) {
            v3 = v1 * (k - 1) + v2 * (k - 1);
            v1 = v2;
            v2 = v3;
        }
        return v2;
    }

    public static void main(String[] args) {
        PaintFence pf = new PaintFence();
        System.out.println(pf.numWays(2, 1));
    }
}
