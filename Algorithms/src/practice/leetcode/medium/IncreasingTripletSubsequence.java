package practice.leetcode.medium;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array
 * Your algorithm should run in O(n) time complexity and O(1) space complexity
 *
 * iterate through the array
 * track the min and second min
 * if bigger than
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n <= secondMin) {
                secondMin = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
