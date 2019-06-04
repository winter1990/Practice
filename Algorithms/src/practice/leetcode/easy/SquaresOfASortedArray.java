package practice.leetcode.easy;

/**
 * @array
 *
 * another meaning of the question is sort the abs of the array
 * start from the last element, two pointers from 0 and n - 1
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] a) {
        int n = a.length, i = 0, j = n - 1;
        int[] res = new int[n];
        int index = n - 1;
        while (i <= j) {
            if (Math.abs(a[i]) < Math.abs(a[j])) {
                res[index] = a[j] * a[j--];
            } else {
                res[index] = a[i] * a[i++];
            }
            index--;
        }
        return res;
    }
}
