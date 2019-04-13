package practice.leetcode.easy;

/**
 * @math
 *
 * generalized formula:
 * area = .5(xb-xa)(yc-yb) + .5(xc-xb)(yc-yb) + .5(xc-xb)(ya-yc)
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int[] i : points) {
            for (int[] j : points) {
                for (int[] k : points) {
                    double area = 0.5 * (j[0] - i[0]) * (k[1] - j[1])
                            + 0.5 * (k[0] - j[0]) * (k[1] - j[1])
                            + 0.5 * (k[0] - j[0]) * (i[1] - k[1]);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
}
