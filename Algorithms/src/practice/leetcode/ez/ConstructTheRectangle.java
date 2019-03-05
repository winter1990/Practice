package practice.leetcode.ez;

/**
 * @math
 *
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * 2. The width W should not be larger than the length L, which means L >= W.
 * 3. The difference between length L and width W should be as small as possible.
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) width--;
        return new int[]{area / width, width};
    }
}
