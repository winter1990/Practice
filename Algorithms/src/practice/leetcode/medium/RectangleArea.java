package practice.leetcode.medium;

/**
 * @math
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * problem to solve:
 * 1. area of each rectangle
 * 2. find if two rectangles overlap
 *
 * bottom left corner + top right corner -> two values at top right > bottom left -> (a-c)*(b-d)
 * whether has overlapped area:
 *   left
 *   right
 *   bottom
 *   top
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F);
        int top = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
