package practice.leetcode.medium;

/**
 * @array
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * problems to solve:
 * 1. find the two lines that can hold the most water
 * 2. how to move the pointers to continue searching
 *
 * two vertical lines can form a container
 * for index i, j
 *   the amount of water can be held: min(a[i],a[j])*(j-i)
 *   two pointers start = 0, end = n - 1
 * because the height is min(a[i],a[j]), it is limited by the lower bar. so update the maximum, move the lower one
 * what if height[i] = height[j]
 *   when we move the either pointer, the width is getting smaller
 *   the only way we can get a larger amount of water is
 *     there are two lines x, y and i < x, y < j
 *     both two lines must be higher than height[i]/[j]
 *   so it does not matter which one to move, if there are two lines larger between (i,j), we will eventually there
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length, start = 0, end = n - 1, res = 0;
        while (start < end) {
            int cur = (end - start) * Math.min(height[start], height[end]);
            res = Math.max(res, cur);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }
}
