package practice.leetcode.hard;

import java.util.Stack;

/**
 * @array
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * [2,1,5,6,2,3], Output: 10
 *
 * brute force
 * for each two bars O(N^2) i and j, get the lowest between [i, j] and get (j - i) * min()
 *
 * problems to solve:
 * 1. how to track back the previous bars with higher/lower height
 * 2. how the lower bar impact the left and right bars and the area
 *
 * the area can be represented as (j-i)*min(a[i],a[j])
 * there are totally 3 cases for two adjacent bars:
 *   h[i] > h[i+1] the current bar becomes the new limit
 *   h[i] < h[i+1] the previous bars become the limit
 *   h[i] = h[i+1] the limit for adjacent two bars is not changed
 * if a[i+1] >= s.peek(), it means we can continue expanding the rectangle a[i] to right to maximize the area
 * if a[i+1] < s.peek(), it means the rectangle with height[s.peek()] ends at current position, so calculate area
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? -1 : heights[i];
            while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] in = {2,1,5,6,2,3};
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        l.largestRectangleArea(in);
    }
}
