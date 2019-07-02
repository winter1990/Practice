package practice.leetcode.medium;

/**
 * @array
 *
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * Given an array A of integers, return the length of the longest mountain.
 * Return 0 if there is no mountain.
 *
 * for a sequence of integers, there are totally 3 scenarios: increasing, flat, decreasing
 * to find the longest mountain, we need to find the increasing numbers and followed by decreasing sequence
 * if it's increasing, we check whether it is the "buttom" and start counting
 * if flat, reset count
 * if decreasing and it was an increasing sequence, continue counting
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int index = 1, count = 1, max = 0;
        while (index < A.length) {
            if (A[index - 1] < A[index]) {
                if (index > 1 && A[index - 2] > A[index - 1]) {
                    count = 1;
                }
                count++;
            } else if (A[index - 1] == A[index]) {
                count = 1;
            } else {
                if (count != 1) {
                    count++;
                    max = Math.max(max, count);
                }
            }
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,2,3};
        LongestMountainInArray lm = new LongestMountainInArray();
        System.out.println(lm.longestMountain(in));
    }
}
