package practice.leetcode.easy;

/**
 * @array
 *
 * another meaning of the question is sort the abs of the array
 * start from the last element, two pointers from 0 and n - 1
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int l = 0;
        int r = A.length - 1;
        int[] res = new int[A.length];
        int index = A.length - 1;
        while (l <= r) {
            if (Math.abs(A[l]) < Math.abs(A[r])) {
                res[index] = A[r] * A[r];
                r--;
            } else {
                res[index] = A[l] * A[l];
                l++;
            }
            index--;
        }
        return res;
    }
}
