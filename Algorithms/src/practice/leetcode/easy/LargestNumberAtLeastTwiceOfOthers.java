package practice.leetcode.easy;

/**
 * keep track of max
 * for each element, current must be twice as max
 * does not work if need index
 *
 * track first and second largest elements
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        int m1 = Integer.MIN_VALUE + 1, m2 = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if (nums[i] != m1 && nums[i] > m2) {
                m2 = nums[i];
            }
        }
        if (m1 / 2 < m2) {
            return -1;
        }
        return index;
    }
}
