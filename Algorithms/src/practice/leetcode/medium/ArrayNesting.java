package practice.leetcode.medium;

/**
 * @array
 *
 * Input: A = [5,4,0,3,1,6,2], Output: 4
 * Explanation: A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]: S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * use another array to track the length of the longest
 * start with 0, if count array = 0, start dfs searching
 * different element MUST indicate different index because they are unique values
 * each element can only be visited ONCE
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        boolean[] isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                max = Math.max(max, dfs(nums, i, isVisited));
            }
        }
        return max;
    }

    private int dfs(int[] nums, int i, boolean[] isVisited) {
        int count = 0;
        int index = i;
        while (!isVisited[index]) {
            isVisited[index] = true;
            index = nums[index];
            count++;
        }
        return count;
    }
}
