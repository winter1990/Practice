package practice.leetcode.hard;

/**
 * @search
 *
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
 *
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to
 * transform the point (sx, sy) to (tx, ty). Otherwise, return False.
 *
 * sx, sy, tx, ty will all be integers in the range [1, 10^9].
 *
 * Input: sx = 1, sy = 1, tx = 3, ty = 5, Output: True
 * Input: sx = 1, sy = 1, tx = 2, ty = 2, Output: False
 *
 * all positive, so x and y increasing
 *
 * dfs from start
 * base case
 *   sx > ex || sy > ty, stop searching
 *   if same, true
 * return dfs() || dfs()
 */
public class ReachingPoints {
    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && sy == ty) return true;
        return reachingPoints1(sx + sy, sy, tx, ty) || reachingPoints1(sx, sy + sx, tx, ty);
    }

    /**
     * optimization
     *
     *                   3,7
     *           10,7             3,10
     *      17,7     10,17
     *
     * 24,7  17,24  27,17  10,27
     *
     *                   37,27 10,37
     *
     *              64,27 37,64
     * from (64,27) to (10,27), we mod by 27
     * if traveling up to right, first number mod second number
     * if traveling up to left, second number mod first number
     * for a pair(a,b)
     *   if a > b, it is left child
     *   if a < b, it is right child
     *
     *
     * so, instead of top down, we can start from the target to do bottom up
     *
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sy == ty && (tx - sx) % sy == 0) return true;
        if (sx == tx && (ty - sy) % sx == 0) return true;
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }

    public static void main(String[] args) {
        ReachingPoints r = new ReachingPoints();
        System.out.println(r.reachingPoints(35,
                13,
                455955547,
                420098884));
    }
}
