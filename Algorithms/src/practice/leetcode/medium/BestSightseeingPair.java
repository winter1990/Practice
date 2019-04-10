package practice.leetcode.medium;

/**
 * @array
 *
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j)
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots.
 * Input: [8,1,5,2,6] Output: 11, index 0 and 2
 * brute force:
 * i [0 n-2], j [i+1, n-1], get the max
 *
 * optimization:
 * we want to maximize a[i] + a[j] + i - j -> (a[i] + i) - (a[j] - j)
 *
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int i = 0, res = 0;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, A[i] + i + A[j] - j);
            if (A[i] + i < A[j] + j) i = j;
        }
        return res;
    }
}
