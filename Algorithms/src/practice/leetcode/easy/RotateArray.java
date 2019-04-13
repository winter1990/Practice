package practice.leetcode.easy;

/**
 * @array
 *
 * method 1
 * create another array
 * and we rotate the array to the right by k steps
 * i = [0, n - 1], (i + k) % n
 * copy each element in the new array back to original array
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int n = nums.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }

    /**
     * method 2
     * in-place with O(1) extra space
     * reverse method O(1) space, O(n) time
     * [1 2 3 4 5 6 7], k = 3 -> [7 6 5 4 3 2 1] -> reverse first 3 elements [5 6 7 4 3 2 1] -> reverse the rest
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
}
