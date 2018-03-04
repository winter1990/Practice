package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * greedy?
 * too many combos
 *
 *
 */
public class PerfectSquares {
    static List<Integer> result = new ArrayList<>();
    public int numSquares(int n) {
        if (result.size() == 0) {
            result.add(0);
        }
        while (result.size() <= n) {
            int m = result.size();
            int tempMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= m; j++) {
                tempMin = Math.min(tempMin, result.get(m - j * j) + 1);
            }
            result.add(tempMin);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        System.out.println(ps.numSquares(12));
    }
}
