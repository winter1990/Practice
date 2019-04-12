package practice.leetcode.medium;

/**
 * @array
 *
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *   For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 *   OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * Return the length of a maximum size turbulent subarray of A.
 *
 * Input: [9,4,2,10,7,8,8,1,9] Output: 5
 * inc -> end with increasing two numbers
 * dec -> end with decreasing two numbers
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) return 0;
        int inc = 1, dec = 1, max = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                inc = dec + 1;
                dec = 1;
            } else if (A[i - 1] > A[i]) {
                dec = inc + 1;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            max = Math.max(max, Math.max(inc, dec));
        }
        return max;
    }

    /**
     * count the longest length of turbulent subarray
     * use count as the flag to indicate the increasing or decreasing
     */
    public int maxTurbulenceSize1(int[] A) {
        int res = 0, count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                count = count > 0 ? ++count : 1;
            } else if (A[i] > A[i + 1]) {
                count = count < 0 ? --count : -1;
            } else {
                count = 0;
            }
            count *= -1;
            res = Math.max(res, Math.abs(count));
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] in = {9,4,2,10,7,8,8,1,9};
        LongestTurbulentSubarray l = new LongestTurbulentSubarray();
        System.out.println(l.maxTurbulenceSize1(in));
    }
}
