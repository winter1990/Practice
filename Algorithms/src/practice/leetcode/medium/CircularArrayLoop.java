package practice.leetcode.medium;

/**
 * @array
 *
 * You are given a circular array nums of positive and negative integers.
 * If a number k at an index is positive, then move forward k steps.
 * Conversely, if it's negative (-k), move backward k steps.
 *
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's
 * length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must
 * not consist of both forward and backward movements.
 *
 * problem to solve:
 * 1. find the circle in the array
 * 2. deal with positive and negative, all numbers in the loop can only be pos OR neg
 * 3. the cycle can start from any element in the array
 *
 * to find the circle - slow & fast runner
 * to make sure two pointers have the same sign a * b >= 0
 *
 * for i = [0, n-1]
 *   slow = i, fast = i + a[i]
 *     for the next step, there are three cases:
 *       1. in the range [0 n-1]
 *       2. < 0 (i + a[i]) % n + n
 *       3. > len (i + a[i]) % n
 *   check if same sign
 *
 *   the direction of two steps for fast pointer must both be the same as slow
 *     slow pointer moves to nextIndex(num, slow)
 *     fast pointer moves to nextIndex(nums, nextIndex(nums, fast))
 *     one corner case:
 *       [3 2 1] the loop only consists of single element
 *       so when circle found (slow = fast), check if the circle is single element
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int slow = i;
            int fast = getNextIndex(nums, i);
            if (nums[slow] * nums[fast] <= 0) continue;
            while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[getNextIndex(nums, fast)] > 0) {
                if (slow == fast) {
                    if (fast == getNextIndex(nums, fast)) break;
                    return true;
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }
        }
        return false;
    }

    private int getNextIndex(int[] a, int i) {
        int n = a.length;
        return (i + a[i]) >= 0 ? (i + a[i]) % n : n + ((i + a[i]) % n);
    }

    public static void main(String[] args) {
//        int[] in = {-1, -2, -3, -4, -5};
        int[] in = {1,2,2,2};
        CircularArrayLoop ca = new CircularArrayLoop();
        System.out.println(ca.circularArrayLoop(in));
    }


}
