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
 * 2. deal with positive and negative, the loop can be either pos or neg
 * 3. when reach tail, need to move the index to head
 * 4. infinite loop [1 2 2 2] -> slow & fast runner method
 *
 * the circle can start from any point in the array
 * if start point is +/- then all the elements in the circle must be +/-
 * so for each element in arr:
 *   start = i, next = i + arr[start], check whether same by arr[i]*arr[next]
 *     if < 0 continue
 *     if > 0 while () keep moving forward until same index
 * to heal with tail <-> head
 *   i+a[i] >= 0 (i+a[i])%len
 *   i+a[i] < 0 len+((i+a[i])%len)
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int slow = i;
            int fast = getNextIndex(nums, i);
            if (nums[slow] * nums[fast] <= 0) {
                continue;
            }
            while (nums[slow] * nums[fast] > 0 && nums[fast] * nums[getNextIndex(nums, fast)] > 0) {
                if (slow == fast) {
                    if (fast == getNextIndex(nums, fast)) {
                        break;
                    }
                    return true;
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }
        }
        return false;
    }

    private int getNextIndex(int[] nums, int i) {
        int len = nums.length;
        return (i + nums[i]) >= 0 ? (i + nums[i]) % len : len + ((i + nums[i]) % len);
    }

    public static void main(String[] args) {
//        int[] in = {-1, -2, -3, -4, -5};
        int[] in = {1,2,2,2};
        CircularArrayLoop ca = new CircularArrayLoop();
        System.out.println(ca.circularArrayLoop(in));
    }


}
