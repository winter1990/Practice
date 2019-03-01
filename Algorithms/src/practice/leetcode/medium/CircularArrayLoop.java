package practice.leetcode.medium;

/**
 * @array
 *
 * Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index and the cycle's
 * length > 1. Furthermore, movements in a cycle must all follow a single direction. In other words, a cycle must
 * not consist of both forward and backward movements.
 *
 * two pointers start and end, which is similar with the linked list finding circle, keep going until they are equal again
 * we need to control and make sure all the numbers are either positive or negative
 * multiplication > 0 means same direction
 *
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
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
        int[] in = new int[]{-1, -2, -3, -4, -5};
        CircularArrayLoop ca = new CircularArrayLoop();
        System.out.println(ca.circularArrayLoop(in));
    }


}
