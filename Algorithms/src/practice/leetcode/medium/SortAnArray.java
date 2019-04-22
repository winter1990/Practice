package practice.leetcode.medium;

/**
 * @sort
 *
 * quick sort:
 * partition - swap - recursion
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int i = low, j = high;
        int pivot = nums[(low + high) / 2];
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (low < j) quickSort(nums, low, j);
        if (i < high) quickSort(nums, i, high);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
