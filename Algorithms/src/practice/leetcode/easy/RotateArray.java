package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * problems to solve:
 * 1. handle different values of k
 * 2. in-place rotate
 *
 * [1 2 3 4 5] k = 2
 * [4 5 1 2 3] output
 *
 * method 1
 * use another array to store the rotated array
 * tmp[(i+k)%n] = nums[i]
 * at last, copy all element in the temporary array to original array
 * O(N), O(N)
 *
 * method 2
 * shift to right k times
 * each time shift by 1 element
 * use a tmp to store the last element, and shift all elements to right
 * at last, arr[0] = tmp
 * repeat the above process k times
 * O(KN)
 *
 * method 3
 * reverse()
 * reverse the whole array
 * reverse(0, k-1)
 * reverse(k,len-1)
 * define a reverse method reverse(array, start, end)
 * O(2N), O(1)
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        while (k-- > 0) {
            int tmp = nums[n - 1];
            for (int i = n - 1; i >= 0; i--) nums[i] = nums[i - 1];
            nums[0] = tmp;
        }
    }

    public void rotate2(int[] nums, int k) {
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
