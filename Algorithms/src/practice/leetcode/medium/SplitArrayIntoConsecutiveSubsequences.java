package practice.leetcode.medium;

/**
 * split them into several subsequences, where each subsequences consist of at least 3 consecutive integers
 * 1 2 3 3 4 5     true
 * 1,2,3,3,4,4,5,5 true 1 2 3 4 5, 3 4 5
 * 1,2,3,4,4,5     false
 *
 * 
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

    }
}
