package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @math
 *
 * return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths
 *
 * if we want to form a triangle, the condition is a + b > c
 * because of the largest triangle we are looking for, sort the array and start with last element
 * define two pointers - left and right, right = i - 1, left = i - 2. but if left+right<i, there is no need
 * to further check the elements on the left because the sum will be smaller
 * so just simply check the 3 adjacent elements from right to left
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
