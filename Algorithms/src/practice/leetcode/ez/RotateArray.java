package practice.leetcode.ez;

/**
 * 1. brute force - O(1) space, O(nk) time
 * 2. extra space - O(n), O(n)
 *
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
//        k = n % k; // k might be 0, so do not need

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }


    /**
     * reverse method O(1) space, O(n) time
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }

    public void rotate2(int[] nums, int k) {

    }
}
