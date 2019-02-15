package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 * @sort
 *
 * duplicate may exist - 115 151 511
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 1234 1243 1324 1342 1423 1432 2134 2143 2314 2341
 * from right to left, find the non-increasing element, swap with left element (check 0)
 * sort the sub array
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) {
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }
        sort(nums, index, nums.length);
        int j = index;
        while (nums[j] <= nums[index - 1]) {
            j++;
        }
        swap(nums, index - 1, j);
    }

    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public void sort(int[] num, int start, int end) {
        Arrays.sort(num, start, end);
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] input = {1,1,1};
        np.nextPermutation(input);
    }
}
