package practice.leetcode.hard;

/**
 * @array
 *
 * sort the array - O(nlogn)
 * iterate the array - O(n)
 *
 * we are looking for FIRST missing
 * [1,2,0] return 3
 * [3,4,-1,1] return 2
 * [2,-1,-3,4,3] return 1
 * [2,-3,-1,10,4,1],[-3,2,-1,10,4,1],[-3,2,-1,4,10,1],[1,2,-1,4,10,-3]
 *
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        int i = 0;
        for (; i < n; i++) {
            if (nums[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }
}
