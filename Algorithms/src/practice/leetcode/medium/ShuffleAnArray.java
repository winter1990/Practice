package practice.leetcode.medium;

import java.util.Random;

/**
 * shuffle
 * random generate numbers/indices
 * nums.length
 * Math.random[0,1)
 */
public class ShuffleAnArray {
    int[] num;
    Random rnd;
    public ShuffleAnArray(int[] nums) {
        rnd = new Random();
        this.num = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return num;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int res[] = num.clone();
        for (int i = num.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int tmp = res[index];
            res[index] = res[i];
            res[i] = tmp;
        }
        return res;
    }
}
