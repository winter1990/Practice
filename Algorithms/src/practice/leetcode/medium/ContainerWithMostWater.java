package practice.leetcode.medium;

/**
 * @array
 * @two pointers
 *
 * two pointers
 * calculate the area - Math.min(a[i],a[j]) *(j-i)
 * the shorter one is the limit
 * if same height? need to prove it does not matter which one to move
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        int area;
        while (start < end) {
            area = (end - start) * Math.min(height[start], height[end]);
            max = Math.max(max, area);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return max;
    }
}
