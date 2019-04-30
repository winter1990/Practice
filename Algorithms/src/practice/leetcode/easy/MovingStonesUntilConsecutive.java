package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @math
 *
 * 1 3 6
 */
public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ar = {a, b, c};
        Arrays.sort(ar);
        if (ar[2] - ar[0] == 2) return new int[]{0, 0};
        return new int[]{Math.min(ar[1] - ar[0], ar[2] - ar[1]) <= 2 ? 1 : 2, ar[2] - ar[0] - 2};
    }
}
