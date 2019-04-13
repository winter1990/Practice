package practice.leetcode.easy;

/**
 * @array
 *
 * find overlapped area
 * m=3 n=3, [[2,2][3,3]]
 * 0 0 0    1 1 0    2 2 1
 * 0 0 0 => 1 1 0 => 2 2 1
 * 0 0 0    0 0 0    1 1 1
 */
public class RangeAddition_II {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] point : ops) {
            x = Math.min(x, point[0]);
            y = Math.min(y, point[1]);
        }
        return x * y;
    }
}
