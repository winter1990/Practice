package practice.leetcode.medium;

/**
 * @array
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * Input: [1,0,1,1,0], Output: 4
 *
 * problems to solve:
 * 1. flip at mot one 0 - within the interval/window there is only one 0 or no 0
 * 2. maintain the window
 *
 * [0 1 0 1 1 0]
 * define two pointers:
 * pre = 0 represents last valid position
 * count the total of the subarray [pre, i]
 * max - the max length of subarray
 * i = [0, n-1]
 *   cur += a[i]
 *   if (i - pre + 1 - cur = 2)
 *     keep moving left pointer pre until only one zero left in subarray
 *     while (i - pre + 1 - cur > 1) cur -= a[pre], pre++
 *   max(max, i - pre + 1)
 */
public class MaxConsecutiveOnes_II {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, pre = 0, cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            while (i - pre + 1 - cur > 1) {
                cur -= nums[pre];
                pre++;
            }
            max = Math.max(max, i - pre + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes_II m = new MaxConsecutiveOnes_II();
        int[] in = {0,1,0,0,1,1,0,1,0,1,1};
        System.out.println(m.findMaxConsecutiveOnesWithKFlips(in, 2));
        System.out.println(m.findMaxConsecutiveOnes(in));
    }

    /**
     * follow up
     * what if we are allowed to flip k zeros
     */
    public int findMaxConsecutiveOnesWithKFlips(int[] a, int k) {
        if (a == null) return 0;
        if (a.length <= k) return k;
        int pre = 0, cur = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            cur += a[i];
            while (i - pre + 1 - cur > k) {
                cur -= a[pre];
                pre++;
            }
            max = Math.max(max, i - pre + 1);
        }
        return max;
    }
}
