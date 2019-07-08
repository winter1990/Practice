package practice.leetcode.easy;

/**
 * @math
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 *
 * method 1 - overlapping intervals
 * we think about the intervals/lines in 1D
 * no overlap --------  ----
 * overlap
 * -----
 *       ---
 * if two intervals have overlap area
 *   start = max(start1 start2)
 *   end = min(end1 end)
 *   if start < end, then there is overlap
 * do the same for horizontal and vertical
 *
 * method 2 - more concise
 * if two rectangles overlap
 * there must be a point that lands on both rectangles
 * think about x-axis and y-axis separately
 * (start1 end1) and (start2 end2)
 * for x-axis:
 *   start1 < end2
 *   start2 < end1
 *   if both conditions are satisfied, then there is overlap
 * for y-axis: same
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        int a1 = Math.max(rec1[0], rec2[0]);
        int a2 = Math.min(rec1[2], rec2[2]);
        int b1 = Math.max(rec1[1], rec2[1]);
        int b2 = Math.min(rec1[3], rec2[3]);
        return a1 < a2 && b1 < b2;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }
}
