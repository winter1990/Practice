package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @math
 *
 * all lengths must be the same
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lengths = new long[]{
                calculateLength(p1, p2), calculateLength(p3, p4),
                calculateLength(p2, p3), calculateLength(p1, p4),
                calculateLength(p1, p3), calculateLength(p2, p4)
        };
        long diagonal = 0;
        for (long len : lengths) {
            diagonal = Math.max(diagonal, len);
        }

        long side = 0;
        long countDiagonal = 0;
        for (long len : lengths) {
            if (len == diagonal) {
                countDiagonal++;
            } else {
                side = len;
            }
        }
        if (countDiagonal != 2) {
            return false;
        }
        for (long len : lengths) {
            if (len != side && len != diagonal) {
                return false;
            }
        }
        return true;
    }

    private long calculateLength(int[] p1, int[] p2) {
        return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
    }
}
