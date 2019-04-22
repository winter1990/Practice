package practice.leetcode.medium;

/**
 * @array
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * Input: A = [1,0,1,0,1], S = 2, Output: 4, 0 <= S <= A.length
 *
 * problems to solve:
 * sum = S exactly
 * in the array, there are only 1/0
 * total number of subarrays
 *
 * use an array to keep track of the pre sum with size a.len + 1 and how many time it occurs
 * traverse the array and sum up all the numbers
 *   if sum > target, need to find how many times that (sum - target) occurs, count += presum(sum - target)
 *   if sum = target, there might be tailing 0s after that subarray, this case combined with above case
 *   update presum[sum]++
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] preSum = new int[A.length + 1];
        int sum = 0, count = 0;
        for (int a : A) {
            sum += a;
            if (sum >= S) count += preSum[sum - S];
            if (sum == S) count++;
            preSum[sum]++;
        }
        return count;
    }
}
