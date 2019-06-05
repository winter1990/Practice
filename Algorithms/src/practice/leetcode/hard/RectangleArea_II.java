package practice.leetcode.hard;

/**
 * @math
 * @segmenttree
 *
 * We are given a list of (axis-aligned) rectangles.
 * Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner,
 * and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.
 *
 * Find the total area covered by all rectangles in the plane.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * draw some rectangles and see the overlap
 * the overlapped area is dividing the rectangle into some more rectangles
 * use those rectangles to calculate the overlap with others
 * because if we
 * for i = [0, n]
 *   for j = [i + 1, n]
 * we are calculating rec[i] with all others and for the
 */
public class RectangleArea_II {
    long m = (long) 1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        long res = 0;
        for (int[] rec : rectangles) res += calculateArea(rec);
        for (int i = 0; i < rectangles.length; i++) {
            long overlap = calculateOverlap(rectangles, rectangles[i], i + 1);
            res = (res - overlap + m) % m;
        }
        return (int) res;
    }

    private long calculateOverlap(int[][] recs, int[] r1, int i) {
        if (i == recs.length) return 0;
        int[] r2 = recs[i];
        i++;
        int l = Math.max(r1[0], r2[0]);
        int r = Math.min(r1[2], r2[2]);
        int u = Math.min(r1[3], r2[3]);
        int d = Math.max(r1[1], r2[1]);
        if (l >= r || u <= d) return calculateOverlap(recs, r1, i);
        long res = calculateArea(new int[]{l, d, r, u});
        if (r1[0] < r2[0]) res = (res + calculateOverlap(recs, new int[]{r1[0], r1[1], r2[0], r1[3]}, i)) % m;
        if (r1[1] < r2[1]) res = (res + calculateOverlap(recs, new int[]{l, r1[1], r, r2[1]}, i)) % m;
        if (r1[2] > r2[2]) res = (res + calculateOverlap(recs, new int[]{r, r1[1], r1[2], r1[3]}, i));
        if (r1[3] > r2[3]) res = (res + calculateOverlap(recs, new int[]{l, r2[3], r, r1[3]}, i)) % m;
        return res;
    }

    private long calculateArea(int[] a) {
        return (long) (a[2] - a[0]) * (a[3] - a[1]);
    }
}
