package practice.leetcode.medium;

/**
 * @bitwise
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * hashmap method is straight forward
 *
 * using bitwise thinking, we can know that there are totally 32 digits for an integer
 */
public class SingleNumber_II {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    public int singleNumber1(int[] nums) {
        int[] checker = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) {
                    checker[i]++;
                }
            }
            checker[i] %= 3;
            res |= checker[i] << i;
        }
        return res;
    }
}
