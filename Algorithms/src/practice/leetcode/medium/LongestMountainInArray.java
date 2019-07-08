package practice.leetcode.medium;

/**
 * @array
 *
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 * Return 0 if there is no mountain.
 *
 * the condition to form a mountain
 *  an increasing continuous sequence
 *  followed by a decreasing sequence
 *
 * for two adjacent elements, there are totally 3 scenarios:
 *   increasing - a[i]>a[i-1], count++, when it is a new increasing sequence (2 1 3), then reset count
 *   flat - reset the count
 *   decreasing - count != 1, then we can make sure there was an increasing sequence
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int res = 0, count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                count = 1;
            } else if (A[i] > A[i - 1]) {
                if (i > 1 && A[i - 2] > A[i - 1]) count = 1;
                count++;
            } else {
                if (count > 1) {
                    count++;
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,2,3};
        LongestMountainInArray lm = new LongestMountainInArray();
        System.out.println(lm.longestMountain(in));
    }
}
