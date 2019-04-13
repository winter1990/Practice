package practice.leetcode.easy;

/**
 * @math
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * if two rectangles overlap
 * there must be a point that lands on both rectangles
 * think about x-axis and y-axis separately
 * for x-axis: x1 < x < x4, x3 < x < x2
 * for y-axis: same
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }

    /*
     * first two values -> left bottom corner
     * second two values -> top right corner
     * need to think about 4 corners that may overlap
     *     rec1 x1y1 x2y2     rec 2 x3y3 x4y4
     * tl  x1<x4 y2>y3
     * bl  x1<x4 y1<y4
     * tr  x2>x3 y2>y3
     * br  x2>x3 y1<y4
     * it's stupidly wrong

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[2] && rec1[3] > rec2[1])
                || (rec1[0] < rec2[2] && rec1[1] < rec2[3])
                || (rec1[2] > rec2[0] && rec1[3] > rec2[1])
                || (rec1[2] > rec2[0] && rec1[1] < rec2[3]);
    }
     */
}
