package practice.leetcode.medium;

/**
 * @array
 * @math
 *
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 *
 * [-4, -2, 2, 4], a = -1, b = 3, c = 5 Result: [-23, -5, 1, 7]
 *
 * f(x) = ax^2 + bx + c
 * think about the shape of the function
 * if a > 0, min value -> x = -b/2a
 * if a < 0, max value -> x = -b/2a
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length, i = 0, j = n - 1;
        int[] res = new int[n];
        int index = a > 0 ? n - 1 : 0;
        while (i <= j) {
            int left = calculateValue(nums[i], a, b, c);
            int right = calculateValue(nums[j], a, b, c);
            if (a > 0) {
                if (left > right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index--;
            } else {
                if (left < right) {
                    res[index] = left;
                    i++;
                } else {
                    res[index] = right;
                    j--;
                }
                index++;
            }
        }
        return res;
    }

    private int calculateValue(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }


}
