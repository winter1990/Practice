package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * make a copy of original array
 * sort and compare with original array
 * count the difference
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) res++;
        }
        return res;
    }
}
