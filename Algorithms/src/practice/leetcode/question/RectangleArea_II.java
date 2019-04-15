package practice.leetcode.question;

/**
 * @math
 * @segmenttree
 *
 * We are given a list of (axis-aligned) rectangles.
 * Each rectangle[i] = [x1, y1, x2, y2] , where (x1, y1) are the coordinates of the bottom-left corner,
 * and (x2, y2) are the coordinates of the top-right corner of the ith rectangle.
 * Find the total area covered by all rectangles in the plane.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 */
public class RectangleArea_II {
    long M = (long) 1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        long res = 0;
        for (int[] r : rectangles) res += areaOf(r[0], r[1], r[2], r[3]);
        for (int i = 0; i < rectangles.length; i++) {
            long overlap = overlap(rectangles, rectangles[i], i + 1);
            res = (res - overlap + M) % M;
        }
        return (int) res;
    }

    public long areaOf(int x1, int y1, int x2, int y2) {
        return (long) (x2 - x1) * (y2 - y1);
    }

    public long overlap(int[][] recs, int[] a, int idx) {
        if (idx == recs.length) return 0;
        int[] b = recs[idx++];
        int left = Math.max(a[0], b[0]), right = Math.min(a[2], b[2]), down = Math.max(a[1], b[1]), up = Math.min(a[3], b[3]);
        if (left >= right || up <= down) return overlap(recs, a, idx);
        long res = areaOf(left, down, right, up);
        if (a[0] < b[0]) res = (res + overlap(recs, new int[]{a[0], a[1], b[0], a[3]}, idx)) % M;
        if (b[2] < a[2]) res = (res + overlap(recs, new int[]{b[2], a[1], a[2], a[3]}, idx)) % M;
        if (a[1] < b[1]) res = (res + overlap(recs, new int[]{left, a[1], right, b[1]}, idx)) % M;
        if (b[3] < a[3]) res = (res + overlap(recs, new int[]{left, b[3], right, a[3]}, idx)) % M;
        return res;
    }
}
