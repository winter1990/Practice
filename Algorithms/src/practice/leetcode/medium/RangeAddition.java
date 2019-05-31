package practice.leetcode.medium;

/**
 * @array
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of
 * subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 *
 * brute force
 * straightforward for each triplet, scan through the array from start to end and update the value
 *
 * [0  0  0  0  0]
 *     2       -2
 *        3
 * -2        2
 * -2  0  3  5  3
 * optimization
 * we mark the start index with the value we need to add, it means all the elements after need to add this number
 * then this number need to be subtracted after the end index, so mark it as -a[i]
 * need one more pass to calculate the accumulated sum and get the result
 */
public class RangeAddition {
    public int[] getModifiedArray1(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int s = update[0], e = update[1], v = update[2];
            res[s] += v;
            if (e < length - 1) res[e + 1] -= v;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
