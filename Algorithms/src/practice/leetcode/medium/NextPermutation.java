package practice.leetcode.medium;

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
 * from right to left, we need to find the non-increasing sub sequence [i,n-1]
 * find the value just larger than a[i-1] and swap
 * [1 3 4 2] i = n-1
 * move the pointer till 2
 * sort the subarray [2,)
 * find the value that is larger than arr[i-1]
 * swap(i-1,j)
 * sort the subarray [i,)
 * as the subarray we are trying to sort is decreasing, so no need to use the arrays.sort()
 * define reverse(arr, from, to) to save time
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int n = nums.length, index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) index--;
        if (index > 0) {
            int j = n - 1;
            while (nums[j] <= nums[index - 1]) j--;
            swap(nums, j, index - 1);
        }
        reverse(nums, index, n - 1);
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) swap(arr, i++, j--);
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] input = {4,3,2,1};
        np.nextPermutation(input);
    }
}
