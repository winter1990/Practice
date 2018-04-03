package practice.leetcode.medium;

/**
 * @dp
 * @math
 *
 * A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 * return the number of arithmetic slices in the array
 * 1 2 3 4, 2+1=3
 * 1 2 3 4 5, 3+2+1=6
 * 1 2 3 4 5 6, 4+3+2+1=10
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int total = 0;
        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
                total += count;
            } else {
                count = 0;
            }
        }
        return total;
    }
}
